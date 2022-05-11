package kosta.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserDTO {
	private String userId;
	private String userName;
	
	//1 : 다 의 관계
	private List<CommentbDTO> commentbList;
}
