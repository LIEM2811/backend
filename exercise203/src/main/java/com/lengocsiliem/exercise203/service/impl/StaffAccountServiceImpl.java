package com.lengocsiliem.exercise203.service.impl;

import org.springframework.stereotype.Service;

import com.lengocsiliem.exercise203.entity.StaffAccount;
import com.lengocsiliem.exercise203.repository.StaffAccountRepository;
import com.lengocsiliem.exercise203.service.StaffAccountService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StaffAccountServiceImpl implements StaffAccountService {

    private final StaffAccountRepository staffAccountRepository;

    public StaffAccountServiceImpl(StaffAccountRepository staffAccountRepository) {
        this.staffAccountRepository = staffAccountRepository;
    }

    @Override
    public List<StaffAccount> getAllStaffAccounts() {
        return staffAccountRepository.findAll();
    }

    @Override
    public Optional<StaffAccount> getStaffAccountById(UUID id) {
        return staffAccountRepository.findById(id);
    }

    @Override
    public StaffAccount createStaffAccount(StaffAccount staffAccount) {
        return staffAccountRepository.save(staffAccount);
    }

    @Override
    public StaffAccount updateStaffAccount(UUID id, StaffAccount staffAccount) {
        staffAccount.setId(id);
        return staffAccountRepository.save(staffAccount);
    }

    @Override
    public void deleteStaffAccount(UUID id) {
        staffAccountRepository.deleteById(id);
    }
}
