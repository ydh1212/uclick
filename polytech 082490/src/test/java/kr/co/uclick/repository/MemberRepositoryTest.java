//package kr.co.uclick.repository;
//
//import static org.junit.Assert.assertEquals;
//
//import java.util.Optional;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import kr.co.uclick.configuration.SpringConfiguration;
//import kr.co.uclick.entity.Member;
//import kr.co.uclick.entity.Sample;
//import kr.co.uclick.repository.MemberRepository;
//
//@RunWith(SpringRunner.class)
//@ContextConfiguration(classes = SpringConfiguration.class)
//public class MemberRepositoryTest {
//
//	@Autowired
//	MemberRepository memberRepository;
//	
////	@Test
////	public void test() {
////		Optional<Member> m = memberRepository.findById(1L);
////		Member member = m.get();
////		
////		assertEquals(1,member.getId().longValue());
////	}
//
//	@Test
//	public void testDelete() {
//		Optional<Member> m = memberRepository.findById(1L);
//		Member member = m.get();
//		
//		assertEquals(1,member.getId().longValue());
//	}
//	
//	
//}
