package com.iman.TestLibrary.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iman.TestLibrary.entity.Member;
import com.iman.TestLibrary.repository.MemberRepository;

@Service
public class MemberService {

	@Autowired
	MemberRepository memberRepository;

	@Transactional
	public Member saveMember(Member member) {
		return memberRepository.save(member);
	}

	@Transactional
	public void deletMember(Long id) {
		memberRepository.deleteById(id);
	}

	@Transactional
	public Member updateByid(long id, Member newMem) {
		Member mem = memberRepository.findById(id).get();
		mem.setName(newMem.getName());
		return memberRepository.save(mem);
	}

	public boolean existMember(long id) {
		if (memberRepository.existsById(id)) {
			return true;
		}
		return false;
	}
	
	public List<Member> allMembers(){
		return memberRepository.findAll();
	}

	public Optional<Member> findMemberById(Long id) {
		return memberRepository.findById(id);
	}
	
	public List<Member> findMemberByName(String name){
		return memberRepository.findByName(name);
	}
}
