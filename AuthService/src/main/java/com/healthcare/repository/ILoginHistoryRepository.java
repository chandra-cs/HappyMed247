package com.healthcare.repository;


import com.healthcare.model.entity.LoginHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILoginHistoryRepository extends JpaRepository<LoginHistory,Long> {
}
