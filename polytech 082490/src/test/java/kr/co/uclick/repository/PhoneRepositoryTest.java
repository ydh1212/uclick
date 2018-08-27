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
//import kr.co.uclick.entity.Phone3;
//
//
//@RunWith(SpringRunner.class)
//@ContextConfiguration(classes = SpringConfiguration.class)
//public class PhoneRepositoryTest {
//
//	@Autowired
//	PhoneRepository phoneRepository;
//	
//	@Test
//	public void test() {
//		Optional<Phone3> m = phoneRepository.findById(1L);
//		Phone3 phone = m.get();
//		
//		assertEquals(1,phone.getId().longValue());
//	}
//
//}
