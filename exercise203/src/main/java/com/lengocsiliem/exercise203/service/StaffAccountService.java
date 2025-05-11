package com.lengocsiliem.exercise203.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.lengocsiliem.exercise203.entity.StaffAccount;

public interface StaffAccountService {

    List<StaffAccount> getAllStaffAccounts();

    Optional<StaffAccount> getStaffAccountById(UUID id);

    StaffAccount createStaffAccount(StaffAccount staffAccount);

    StaffAccount updateStaffAccount(UUID id, StaffAccount staffAccount);

    void deleteStaffAccount(UUID id);
}
