package com.iman.TestLibrary.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.iman.TestLibrary.entity.Loan;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long>{
	@Query("SELECT l FROM Loan l WHERE l.member.id = :memberId")
    List<Loan> findByMemberId(@Param("memberId") long memberId);
}