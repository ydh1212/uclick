package kr.co.uclick.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.uclick.entity.Member;
import kr.co.uclick.entity.Phone;
import kr.co.uclick.service.MemberService;
import kr.co.uclick.service.PhoneService;

@Controller
public class MemberController {

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	@Autowired
	private MemberService memberService;
	
	@Autowired
	private PhoneService phoneService;

	@RequestMapping(value = "list.html",method = RequestMethod.GET)
	public String list(Model model) {

		 List<Member> allList = memberService.findAll();
		//model.addAttribute("member", memberService.findAll());
		 model.addAttribute("member",allList);
		return "list";
	}
	@RequestMapping(value = "searchList",method = {RequestMethod.POST, RequestMethod.GET})
	public String searchList(@RequestParam Map<String, String> param, Model model) {  
       String keyword = param.get("keyword");
          String check = param.get("check");
          List<Member> member = new ArrayList<Member>();
          List<Phone> phone = new ArrayList<Phone>();
         if(check.equals("checkname")) {
              member = memberService.findByNameContaining(keyword);
              if(member.size()>0) {
                  model.addAttribute("users", member);
              }
          }
          
          if(check.equals("checkphone")) {
              phone = phoneService.findByNoContaining(keyword);
              for(Phone phones : phone) {
            	  member.add(phones.getMember());
              }
              member= new ArrayList<Member>(new HashSet<Member>(member));
              model.addAttribute("users", member);
          }
          
          
//          String keyword2 = param.get("keyword");
//          String check2 = param.get("check");
//         
//         
//         if(check2.equals("checkname")) {
//              member = memberService.findByNameContaining(keyword);
//              if(member.size()>0) {
//                  model.addAttribute("member", member);
//              }
//          }
//          
//          if(check2.equals("checkphone")) {
//              phone = phoneService.findByNoContaining(keyword);
//              for(Phone phones : phone) {
//            	  member.add(phones.getMember());
//              }
//              member= new ArrayList<Member>(new HashSet<Member>(member));
//              model.addAttribute("member", member);
//          }
          
          
          
          
		return "searchList";
	}

	@RequestMapping(value = "view")
	public String view(@RequestParam Map<String, String> param, Model model) { 
		long id = Integer.parseInt(param.get("id"));
		 
		 Member view = new Member();
		 view.setId(id);
		 Optional<Member> allList = memberService.findById(id);
		//model.addAttribute("member", memberService.findAll());
		 model.addAttribute("id",allList);
		return "view";
	}
	
	
	@RequestMapping(value = "newForm.html")
	public String newForm(Model model) {
		return "newForm";
	}

	

	@RequestMapping(value = "update")
	public String update(@RequestParam Map<String, String> param, Model model) { 
		long id = Integer.parseInt(param.get("id"));
	    Member update = new Member();
	    update.setId(id);
	    Optional<Member> updateList = memberService.findById(id);

		model.addAttribute("id",updateList);
		return "update";
	}
	
	@RequestMapping(value = "editForm", method = RequestMethod.POST)
	public String editForm(@RequestParam Map<String, String> param, Model model) { 
		long id = Integer.parseInt(param.get("id"));
		long pid = Integer.parseInt(param.get("pid"));
		String age = param.get("age");
		String sex = param.get("sex");
		String name = param.get("name");
		String no = param.get("no");
		
		Optional<Member> updateList = memberService.findById(id);
		
		updateList.get().setAge(age);
		updateList.get().setSex(sex);
		updateList.get().setName(name);
		
		Optional<Phone> phone = phoneService.findById(pid);
		
		phone.get().setNo(no);
		
		phone.get().setMember(updateList.get());
		memberService.save(updateList.get());
		phoneService.save(phone.get());
		return "redirect:list.html";
	}
	
	
	@RequestMapping(value = "insert")
	public String insert(Model model) {
		
		return "insert";
	}
	
	@RequestMapping(value = "save.html", method = RequestMethod.POST)
	public String save(@RequestParam Map<String, String> param, Model model) { 
		String age = param.get("age");
		String sex = param.get("sex");
		String name = param.get("name");
		String no = param.get("no");
		
		
		Member insert = new Member();
		insert.setAge(age);
		insert.setSex(sex);
		insert.setName(name);
		
		Phone insert2 = new Phone();
		
		insert2.setNo(no);
		
		;
		insert2.setMember(insert);
		memberService.save(insert);
		phoneService.save(insert2);
		return "redirect:list.html";
	}
	
	@RequestMapping(value = "phoneInsert", method = RequestMethod.POST)
	public String phoneInsert(@RequestParam Map<String, String> param, Model model) {
		String no = param.get("no");
		long id = Integer.parseInt(param.get("id"));
	    Phone pinsert = new Phone();
	    pinsert.setNo(no);
	    Optional<Member> updateList = memberService.findById(id);
        pinsert.setMember(updateList.get());
        phoneService.save(pinsert);
		model.addAttribute("id",updateList);
		return "redirect:view?id="+id;
	}

	@RequestMapping(value = "delete")
	public String delete(Locale locale, @RequestParam Map<String, String>param, Model model) { 
		Long id = Long.parseLong(param.get("id"));
		Optional<Member> member = memberService.findById(id);
        memberService.delete(member.get());
		return "redirect:list.html";
	}
	
	@RequestMapping(value = "phoneDelete",method = {RequestMethod.POST, RequestMethod.GET})
	public String phoneDelete(Locale locale, @RequestParam Map<String, String>param, Model model) { 
		Long mid = Long.parseLong(param.get("mid"));
		Long id = Long.parseLong(param.get("id"));
		Optional<Phone> phone = phoneService.findById(id);
        phoneService.delete(phone.get());
        return "redirect:list.html";
		
	}

//	@RequestMapping(value = "sample.html")
//	public String sample(String name, Member member, Model model) {
//
//		logger.debug("sample name : {}", name);
//		logger.debug("Sample.name : {}", member.getName());
//
//		model.addAttribute("samples", memberService.findAll());
//		model.addAttribute("sample", member);
//		model.addAttribute("findSampleByName", memberService.findByName(name));
//		return "sample";
//	}
	
}
