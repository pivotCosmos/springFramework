package kosta.mvc.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {
   private String code;
   private String name;
   private int price;
   private String detail;

	//lombok이용해서 set, get만든다.
   
}
