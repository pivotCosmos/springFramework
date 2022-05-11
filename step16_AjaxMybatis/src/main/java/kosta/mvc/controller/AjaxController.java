package kosta.mvc.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kosta.mvc.dto.Member;

@RestController //@Controller + @ResponseBody 조합
public class AjaxController {
	
	@RequestMapping(value = "/load" , produces = "text/html;charset=UTF-8") //한글 깨짐 방지
	public String load() { //기본적으로 String리턴값은 뷰 이름이지만 RestController라서.... ajax
		return "Ajax와 Spring의 만남~~"; //한글이 깨진다.
	}
	
	@RequestMapping(value = "/ajax" , produces = "text/html;charset=UTF-8") //한글 깨짐 방지
	public String ajax(String name) {
		System.out.println("name : " + name);
		return name + "님 반가워요^^";
	}
	
	/**
	 * java의 객체를 응답해주기 위해서는 json으로 변환해주는
	 * jackson LIB가 필요하다.
	 * json으로 변환할 때는 produces = "text/html;charset=UTF-8" 처럼 타입(html같은) 정하면 안된다.
	 * */
	@RequestMapping(value = "/json")
	public List<String> json() { 
		System.out.println("json요청됨......");
		return Arrays.asList("짬뽕","짜장면","탕수육","팔보채","유산슬","볶음밥","양장피");
	}
	
	@RequestMapping(value = "/memberDto")
	public Member test() { 
		return new Member("jang","장희정",20,"서울");
	}
	
	@RequestMapping("/memberList")
	public List<Member> test2() { 
		List<Member> list = new ArrayList<>();
		
		list.add(new Member("jang","장희정",20,"서울"));
		list.add(new Member("king","김김김",16,"대구"));
		list.add(new Member("angel","이철수",70,"울산"));
		list.add(new Member("puppy","강수진",50,"춘천"));
		list.add(new Member("puddle","김미정",40,"부산"));
		list.add(new Member("mountain","손연재",30,"인천"));
		
		return list;
	}
	
	@RequestMapping("/map")
	public Map<String, Object> test3() { 
		Map<String, Object> map = new HashMap<>();
		map.put("message", "Spring 최고!!!");
		map.put("pageNo", 10);
		map.put("dto", new Member("jang","장희정",20,"서울"));
		
		List<Member> list = new ArrayList<>();
		list.add(new Member("king", "김김김", 16, "대구"));
		list.add(new Member("angel", "이철수", 70, "울산"));
		list.add(new Member("puppy", "강수진", 50, "춘천"));
		list.add(new Member("puddle", "김미정", 40, "부산"));
		list.add(new Member("mountain", "손연재", 30, "인천"));
		
		map.put("memberList", list);
		
		return map;
	}
}
