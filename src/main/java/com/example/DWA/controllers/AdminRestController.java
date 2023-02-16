package com.example.DWA.controllers;

import com.example.DWA.entities.Admin;
import com.example.DWA.repositorys.AdminRepository;
import com.example.DWA.services.AdminService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.ws.server.endpoint.annotation.XPathParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/admin")
public class AdminRestController {

    private AdminRepository adminRepository;
    @Autowired
    private AdminService adminService;
    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    @Autowired
    public AdminRestController(AdminRepository adminRepository){
        this.adminRepository = adminRepository;
    }

    @RequestMapping(value = "/ajouterAdmin", method = RequestMethod.POST)
    public Admin ajouterAdmin(@RequestBody Admin admin){
        admin.setMdp(this.bCryptPasswordEncoder.encode(admin.getMdp()));
        return adminService.saveAdmin(admin);
    }
    @RequestMapping(value = "/modifierAdmin", method = RequestMethod.PUT)
    public Admin modifierAdmin(@RequestBody Admin admin){
        return adminService.updateAdmin(admin);
    }
    @RequestMapping(value = "/supprimerAdmin/{id}", method = RequestMethod.DELETE)
    public void supprimerAdmin(@PathVariable("id") Long id){
        adminService.deleteAdmin(id);
    }
    @RequestMapping(value = "/listeAdmin", method = RequestMethod.GET)
    public List<Admin> listeAdmin(){
        return adminService.getAllAdmins();
    }
    @PostMapping(path = "/register")
    public ResponseEntity<Admin> addAdmin(@RequestBody Admin admin) {
        admin.setMdp(this.bCryptPasswordEncoder.encode(admin.getMdp()));
        Admin savedAdmin = adminRepository.save(admin);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAdmin);
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> loginAdmin(@RequestBody Admin admin) {
        System.out.println("in login-admin"+admin);
        HashMap<String, Object> response = new HashMap<>();

        Admin userFromDB = adminRepository.findAdminByEmail(admin.getEmail());
        System.out.println("userFromDB+admin"+userFromDB);
        if (userFromDB == null) {
            response.put("message", "admin not found !");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        } else {
            boolean compare = this.bCryptPasswordEncoder.matches(admin.getMdp(), userFromDB.getMdp());
            System.out.println("compare"+compare);
            if (!compare) {
                response.put("message", "client not found !");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            }else
            {
                String token = Jwts.builder()
                        .claim("data", userFromDB)
                        .signWith(SignatureAlgorithm.HS256, "SECRET")
                        .compact();
                response.put("token", token);
                System.out.println("hhh");
                return ResponseEntity.status(HttpStatus.OK).body(response);
            }

        }
    }
    @RequestMapping(value = "/consulterAdmin/{id}")
    public Admin consulterAdmin(@PathVariable("id") Long id){
        return adminService.getAdmin(id);
    }
}
