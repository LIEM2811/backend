package com.lengocsiliem.exercise203.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.lengocsiliem.exercise203.entity.StaffAccount;
import com.lengocsiliem.exercise203.service.StaffAccountService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/staff-accounts")
public class StaffAccountController {

    private final StaffAccountService staffAccountService;

    public StaffAccountController(StaffAccountService staffAccountService) {
        this.staffAccountService = staffAccountService;
    }

    @GetMapping
    public List<StaffAccount> getAllStaffAccounts() {
        return staffAccountService.getAllStaffAccounts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StaffAccount> getStaffAccountById(@PathVariable UUID id) {
        return ResponseEntity.of(staffAccountService.getStaffAccountById(id));
    }

    @PostMapping
    public StaffAccount createStaffAccount(@RequestBody StaffAccount staffAccount) {
        return staffAccountService.createStaffAccount(staffAccount);
    }

    @PutMapping("/{id}")
    public StaffAccount updateStaffAccount(@PathVariable UUID id, @RequestBody StaffAccount staffAccount) {
        return staffAccountService.updateStaffAccount(id, staffAccount);
    }

    @DeleteMapping("/{id}")
    public void deleteStaffAccount(@PathVariable UUID id) {
        staffAccountService.deleteStaffAccount(id);
    }
}
