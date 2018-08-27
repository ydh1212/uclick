package kr.co.uclick.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.uclick.entity.Phone;
import kr.co.uclick.repository.PhoneRepository;

@Service
@Transactional
public class PhoneService {

	@Autowired
	private PhoneRepository phoneRepository;

	public void delete(Phone phone) {
		phoneRepository.delete(phone);
	}

	@Transactional(readOnly = true)
	public List<Phone> findAll() {
		return phoneRepository.findAll();
	}

	public void save(Phone phone) {
		phoneRepository.save(phone);
	}

	public Optional<Phone> findById(Long Id) {
		return phoneRepository.findById(Id);
	}

	public List<Phone> findByNoContaining(String no) {
		return phoneRepository.findByNoContaining(no);
	}
}
