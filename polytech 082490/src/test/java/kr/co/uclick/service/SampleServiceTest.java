package kr.co.uclick.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StopWatch;

import kr.co.uclick.configuration.SpringConfiguration;
import kr.co.uclick.entity.Sample;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class SampleServiceTest {

	@Autowired
	SampleService sampleService;
	
//	@Test
//	public void test() {
//		Optional<Member> m = memberRepository.findById(1L);
//		Member member = m.get();
//		
//		assertEquals(1,member.getId().longValue());
//	}

//	@Test
//	public void testDelete() {
//		Optional<Member> m = sampleService.findById(1L);
//		Member member = m.get();
//		
//		assertEquals(1,member.getId().longValue());
//	}
	
	
//	@Test
//	public void testSelectOne() {
//		StopWatch sw = new StopWatch();
//		sw.start();
//		Sample s1 = sampleService.selectOne(1L);
//		sw.stop();
//		
//		System.out.println("total time : " + sw.getTotalTimeSeconds());
//		
//		sw= new StopWatch();
//		sw.start();
//		Sample s2 = sampleService.selectOne(1L);
//		sw.stop();
//		
//		System.out.println("total time : " + sw.getTotalTimeSeconds());
//		
//		
//		assertEquals(1,s1.getId().intValue());
//	}
	
	
	@Test
	public void testSelectOne() {
		StopWatch sw = new StopWatch();
        sw.start();
        Sample s1 = sampleService.selectOne(1L);
        sw.stop();
        System.out.println("1 total time : " + sw.getTotalTimeSeconds() + " " + s1.getName());
        
        sw = new StopWatch();
        sw.start();
        s1 = sampleService.selectOne(1L);
        sw.stop();
        System.out.println("2 total time : " + sw.getTotalTimeSeconds() + " " + s1.getName());
        
        s1.setName("a7");
        sampleService.updateOne(s1);
        
        sw = new StopWatch();
        sw.start();
        s1 = sampleService.selectOne(1L);
        sw.stop();
        System.out.println("3 total time : " + sw.getTotalTimeSeconds() + " " + s1.getName());
        
        sw = new StopWatch();
        sw.start();
        s1 = sampleService.selectOne(1L);
        sw.stop();
        System.out.println("4 total time : " + sw.getTotalTimeSeconds() + " " + s1.getName());
        
//        assertEquals(1, s1.getId().intValue());
    }
    

}