package com.example.DWA.services;

import com.example.DWA.entities.Admin;
import com.example.DWA.repositorys.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AdminServiceImpli implements AdminService{
    @Autowired
    AdminRepository adminRepository;
    @Override
    public Admin saveAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    @Override
    public Admin updateAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    @Override
    public void deleteAdmin(Long id) {
         adminRepository.deleteById(id);
    }

    @Override
    public Admin getAdmin(Long id) {
        return adminRepository.findById(id).get();
    }

    @Override
    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

}
