package kr.co.uclick.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.uclick.entity.Member;

import kr.co.uclick.repository.MemberRepository;

@Service
@Transactional
public class MemberService {

	@Autowired
	private MemberRepository memberRepository;

	public void delete(Member member) {
		memberRepository.delete(member);
	}
	


	@Transactional(readOnly = true)
	public List<Member> findAll() {
		return memberRepository.findAll();
	}

	@Transactional(readOnly = true)
	public List<Member> findByNameContaining(String name) {

//		memberRepository.findAll(QSample.sample.name.eq(name));
		memberRepository.doSample(name);

		return memberRepository.findByNameContaining(name);
	}

	public void save(Member member) {
		memberRepository.save(member);
	}

	public Optional<Member> findById(Long Id) {
		return memberRepository.findById(Id);
	}
}
