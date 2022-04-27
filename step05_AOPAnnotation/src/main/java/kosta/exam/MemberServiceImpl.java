package kosta.exam;

import org.springframework.stereotype.Service;

@Service("target")
public class MemberServiceImpl implements MemberService {

	@Override
	public int insert() {
		System.out.println("MemberServiceImpl의 insert()의 핵심기능....");
		return 50;
	}

	@Override
	public String select(int i) {
		System.out.println("MemberServiceImpl의 elect(int i)의 핵심기능....");
		
		if(i==0)throw new RuntimeException("0을 입력하면 안돼요");
		return "aop공부하는날";
	}

	@Override
	public void update(String id, String name) {
		System.out.println("MemberServiceImpl의 update(String id, String name)의 핵심기능....");

	}

}
