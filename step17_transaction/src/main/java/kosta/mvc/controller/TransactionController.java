package kosta.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kosta.mvc.dto.TransferDTO;
import kosta.mvc.exception.MyException;
import kosta.mvc.service.TransferService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class TransactionController {

	private final TransferService transferService;
	
	@RequestMapping("/")
	public String index() {
		return "transaction"; // WEB-INF/views/transaction.jsp�̵�
	}
	
	@RequestMapping("/transfer")
	public String transfer(TransferDTO transferDTO) throws MyException{
		
		transferService.transfer(transferDTO);
		
		return "result";
	}
	
	//@ExceptionHandler(RuntimeException.class)
	@ExceptionHandler(MyException.class)
	public ModelAndView error(MyException e) {
		return new ModelAndView("error", "errMessage", e.getMessage());
	}
}
