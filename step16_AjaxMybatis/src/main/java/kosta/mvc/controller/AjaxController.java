package kosta.mvc.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kosta.mvc.dto.Member;

@RestController //@Controller + @ResponseBody ����
public class AjaxController {
	
	@RequestMapping(value = "/load" , produces = "text/html;charset=UTF-8") //�ѱ� ���� ����
	public String load() { //�⺻������ String���ϰ��� �� �̸������� RestController��.... ajax
		return "Ajax�� Spring�� ����~~"; //�ѱ��� ������.
	}
	
	@RequestMapping(value = "/ajax" , produces = "text/html;charset=UTF-8") //�ѱ� ���� ����
	public String ajax(String name) {
		System.out.println("name : " + name);
		return name + "�� �ݰ�����^^";
	}
	
	/**
	 * java�� ��ü�� �������ֱ� ���ؼ��� json���� ��ȯ���ִ�
	 * jackson LIB�� �ʿ��ϴ�.
	 * json���� ��ȯ�� ���� produces = "text/html;charset=UTF-8" ó�� Ÿ��(html����) ���ϸ� �ȵȴ�.
	 * */
	@RequestMapping(value = "/json")
	public List<String> json() { 
		System.out.println("json��û��......");
		return Arrays.asList("«��","¥���","������","�Ⱥ�ä","���꽽","������","������");
	}
	
	@RequestMapping(value = "/memberDto")
	public Member test() { 
		return new Member("jang","������",20,"����");
	}
	
	@RequestMapping("/memberList")
	public List<Member> test2() { 
		List<Member> list = new ArrayList<>();
		
		list.add(new Member("jang","������",20,"����"));
		list.add(new Member("king","����",16,"�뱸"));
		list.add(new Member("angel","��ö��",70,"���"));
		list.add(new Member("puppy","������",50,"��õ"));
		list.add(new Member("puddle","�����",40,"�λ�"));
		list.add(new Member("mountain","�տ���",30,"��õ"));
		
		return list;
	}
	
	@RequestMapping("/map")
	public Map<String, Object> test3() { 
		Map<String, Object> map = new HashMap<>();
		map.put("message", "Spring �ְ�!!!");
		map.put("pageNo", 10);
		map.put("dto", new Member("jang","������",20,"����"));
		
		List<Member> list = new ArrayList<>();
		list.add(new Member("king", "����", 16, "�뱸"));
		list.add(new Member("angel", "��ö��", 70, "���"));
		list.add(new Member("puppy", "������", 50, "��õ"));
		list.add(new Member("puddle", "�����", 40, "�λ�"));
		list.add(new Member("mountain", "�տ���", 30, "��õ"));
		
		map.put("memberList", list);
		
		return map;
	}
}
