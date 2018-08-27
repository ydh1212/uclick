//package kr.co.uclick.service;
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
//import kr.co.uclick.entity.Phone;
//
//
//
//
//
//
//@RunWith(SpringRunner.class)
//@ContextConfiguration(classes = SpringConfiguration.class)
//public class PhoneServiceTest {
//
//	@Autowired
//	PhoneService phoneService;
//	
//	@Test
//	public void test() {
//		Optional<Phone> m = phoneService.findById(1L);
//		Phone phone = m.get();
//		
//		assertEquals(1,phone.getId().longValue());
//	}
//
//}
