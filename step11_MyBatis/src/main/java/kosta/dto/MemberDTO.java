package kosta.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class MemberDTO {
	private String userId;
	private String userName;
	private int userAge;
	private String userAddr;
}
