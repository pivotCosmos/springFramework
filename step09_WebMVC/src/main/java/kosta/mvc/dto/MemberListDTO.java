package kosta.mvc.dto;

import java.util.List;

public class MemberListDTO {
	private List<Member> list; //�信�� name="list[0].state"

	public List<Member> getList() {
		return list;
	}

	public void setList(List<Member> list) {
		this.list = list;
	}
	
	
}
