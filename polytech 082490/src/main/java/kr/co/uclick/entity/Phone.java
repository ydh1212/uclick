package kr.co.uclick.entity;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.xml.bind.annotation.XmlElement;

@Entity
@Table(name = "phone")
public class Phone {

	@Id
	@TableGenerator(name = "phone")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "phone")
	@Column
	private Long id;

	@ManyToOne(targetEntity = Member.class)
	private Member member;

	@Column
	private String no;
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Phone() {
	}

	public Phone(String no) {
		this.no = no;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}



}
