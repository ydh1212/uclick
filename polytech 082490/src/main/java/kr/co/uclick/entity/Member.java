package kr.co.uclick.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "members")
public class Member {

	@Id
	@TableGenerator(name = "member")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "member")
	@Column
	private Long id;

	@OneToMany(mappedBy = "member", fetch = FetchType.EAGER)
	private List<Phone> phoneList;

	@Column(length = 20)
	private String name;

	@Column
	private String age;

	@Column
	private String sex;

	public Member() {
	}

	public Long getId() {
		return id;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Phone> getPhoneList() {
		return phoneList;
	}

	public void setPhoneList(List<Phone> phoneList) {
		this.phoneList = phoneList;
	}

//	public Collection<Phone> getPhone() {
//		return phone;
//	}
//
//	public void setPhone(Collection<Phone> phone) {
//		this.phone = phone;
//	}
	

}
