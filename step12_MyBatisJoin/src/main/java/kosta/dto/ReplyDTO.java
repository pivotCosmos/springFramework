package kosta.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ReplyDTO {
	private int replyNo;
	private int commentNo;
	private String userId;
	private String replyContent;
	private String regDate;
}
