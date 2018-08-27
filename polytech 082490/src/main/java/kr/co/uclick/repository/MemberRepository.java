package kr.co.uclick.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import kr.co.uclick.entity.Member;


public interface MemberRepository extends JpaRepository<Member, Long> ,QuerydslPredicateExecutor<Member>,CustomSampleRepository{
//	public List<Member> findByName(String name);
//	List<Member> selectAllByPagination(int page, int itemSizePerPage);
//	public void doMember(String name);
//	List<Member> findAll();
//	List<Member> findAll(Sort sort);
	public List<Member> findByNameContaining(String name);
}


