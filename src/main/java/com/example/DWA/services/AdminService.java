package com.example.DWA.services;

import com.example.DWA.entities.Admin;

import java.util.List;

public interface AdminService {
     Admin saveAdmin(Admin admin);
     Admin updateAdmin(Admin admin);
     void deleteAdmin(Long id);
     Admin getAdmin(Long id);
     List<Admin> getAllAdmins();
}
