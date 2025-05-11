
package com.lengocsiliem.exercise203.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lengocsiliem.exercise203.entity.StaffAccount;

import java.util.UUID;

public interface StaffAccountRepository extends JpaRepository<StaffAccount, UUID> {
}
