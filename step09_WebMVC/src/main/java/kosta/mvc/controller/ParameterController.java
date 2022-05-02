package kosta.mvc.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kosta.mvc.dto.Member;

@Controller //����
@RequestMapping("/param")
public class ParameterController {

	/**
	 * ������ void�ΰ��� ���� �̸��� ��û�ּҰ� �ȴ�.
	 *   ���⼭�� WEB-INF/views/param/a.jsp�̵�
	 * */
	/*@RequestMapping("/a.do")
	public void aa(HttpServletRequest request) {
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		
		System.out.println("name : " + name + ", age : " + age);
		
		System.out.println("param/a.do��û�Ǿ����ϴ�....");
	}*/
	
	
	/**
	 * ����Ÿ���� void, String�϶� �������� �����ؾ��ϴ� ������ �ִ°��
	 * �μ� Model�� �������� ���޵� ��ü�� ���Ѵ�.
	 * */
	@RequestMapping("/a.do")
	public void aa(String name, Integer age, Model model) { //int�� �ϸ� null�϶� ������ - Integer���� �ذ�
		
		System.out.println("name : " + name + ", age : " + age);
		
		model.addAttribute("message", "����Ŀ�~~ ���Ĺ�����??"); //�信�� @{requestScope.message}
		model.addAttribute("hobbys", Arrays.asList("���","����","����","����")); //�信�� ${hobbys}
		
		System.out.println("param/a.do��û�Ǿ����ϴ�....");
	}
	
	/**
	 * �μ��� Member��ü�� ������ ������ ���޵Ǵ� 'name�� ��ġ�ϴ�' Member��
	 * �Ӽ��� ã�� setXxx()�ڵ����� ȣ��ȴ�.
	 * 
	 *   : �μ��� ��ü(DTO=VO) ���¸� ������ �� ������ �������� �״�� ���޵Ǿ�
	 *     �信�� ����Ҽ� �ִ�.
	 *      ������� Ŭ���� �̸� ù���ڸ� �ҹ��ڷ� �� ${member}
	 *      
	 *      ����, Ŭ�����̸� �ʹ� ��ų� ��ƴٸ�
	 *      @ModelAttribute�� �̿��ؼ� ��Ī�� ���� ����Ҽ��ִ�.
	 * */
	@PostMapping("/c.do")
	public String cc(@ModelAttribute("m") Member mem) {
		
		System.out.println("member : " + mem);
		//���� -> dao ����� �Ϸ��� �Ŀ�...
		
		return "paramResult"; // WEB-INF/view/paramResult.jsp
	}
	///////////////////////////////////////
	
	/**
	 * ���� Controller�� ��ȴ� ���� ��� ��û�� ��� ����������
	 * Model������ ����� �� �ֵ�. �信�� ${addr}, ${menus}
	 * */
	@ModelAttribute("addr")
	public String aaa() {
		return "��⵵ ������ ������";
	}
	
	@ModelAttribute("menus")
	public List<String> menus(){
		return Arrays.asList("«��","¥��","������","��ǳ��");
	}
	
	@RequestMapping("/d.do")
	public String d(
			@RequestParam(value="id", required = false) String userId,
			@RequestParam(defaultValue = "0") int age,
			@RequestParam(defaultValue = "Guest") String name) {
		
		System.out.println("param/d.do ��û�Ǿ����ϴ�.....");
		System.out.println("userId : " + userId);
		System.out.println("age : " + age);
		System.out.println("name : " + name);
		
		return "result"; //WEB-INF/views/result.jsp�̵�
	}
	
}
