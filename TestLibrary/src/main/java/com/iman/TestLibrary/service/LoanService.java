package com.iman.TestLibrary.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iman.TestLibrary.entity.Loan;
import com.iman.TestLibrary.repository.LoanRepository;

@Service
public class LoanService {
	@Autowired
	LoanRepository loanRepository;
	
	@Transactional
	public Loan saveLoan(Loan loan){
		return loanRepository.save(loan);
	}
	
	@Transactional
	public void deleteLoan(long id) {
		loanRepository.deleteById(id);
	}
	
	@Transactional
	public Loan updateEndDateLoan(long id, Loan newLoan) {
		Loan loan = loanRepository.findById(id).get();
		loan.setEndDate(newLoan.getEndDate());
		return loanRepository.save(loan);
	}
	
	public boolean existLoan(long id) {
		if(loanRepository.existsById(id)) {
			return true;
		}
		return false;
	}
	
	public List<Loan> allLoans(){
		return loanRepository.findAll();
	}
	
	public Optional<Loan> findLoanById(long id) {
		return loanRepository.findById(id);
	}
	
	public List<Loan> findLoanByMemberId(long id){
		return loanRepository.findByMemberId(id);
	}
}
