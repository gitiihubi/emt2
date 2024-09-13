package com.iman.TestLibrary.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iman.TestLibrary.entity.Member;
@Repository
public interface MemberRepository extends JpaRepository<Member, Long>{
	
	List<Member> findByName(String name);
}
