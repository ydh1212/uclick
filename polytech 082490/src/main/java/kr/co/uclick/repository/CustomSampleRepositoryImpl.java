package kr.co.uclick.repository;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import kr.co.uclick.entity.Sample;

public class CustomSampleRepositoryImpl implements CustomSampleRepository {

	private static final Logger logger = LoggerFactory.getLogger(CustomSampleRepositoryImpl.class);

	@Override
	public void doSample(String name) {
		logger.debug("doSample : {}, {}", name, 1);
	}

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Cacheable(value = "area")
    public Sample selectOne(Long id) {
        sleep(3000);
        
        String hql = "FROM Sample u WHERE u.id = " + id;
        Query query = getSession().createQuery(hql).setCacheable(true);
        return (Sample) query.uniqueResult();
    }
    
    private void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    @CacheEvict(value = "area", key="#sample.id")
    public void updateOne(Sample sample) {
        getSession().saveOrUpdate(sample);
    }

}