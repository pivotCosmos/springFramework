package kosta.mvc.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TransferDTO {
   private String output; //��ݰ��¹�ȣ
   private String input;//�Աݰ��¹�ȣ
   private int transferAmount;// ������ü �� �ݾ�
   
}
