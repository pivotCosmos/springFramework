package kosta.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kosta.mvc.dto.ProductDTO;
import kosta.mvc.exception.MyErrorException;
import kosta.mvc.service.ProductService;

@Controller //���� id="productController"
public class ProductController {
	
	@Autowired //����
	private ProductService productService;
	
	@RequestMapping("/index.kosta")
	public String index(Model model) {
		
		List<ProductDTO> productList = productService.select();
		model.addAttribute("productList", productList); //�信�� ${productList} ���
		
		return "productList"; //WEB-INF/views/productList.jsp�̵�
	}
	
	/**
	 * �����
	 * */
	//@RequestMapping("/insertForm.kosta")
	@RequestMapping("/{url}.kosta")
	public void form() {
		
	}
	
	
	/**
	 * ����ϱ�
	 * */
	//@RequestMapping("/insert.kosta")
	@PostMapping("/insert.kosta")
	public String insert(ProductDTO productDTO) throws MyErrorException{
		
		productService.insert(productDTO);
		
		//return "test"; //���ϰ��� ���̸��� �ȴ�.
		//return "forward:/test"; // request,response�� �����ϸ鼭 @ReqeuestMapping("/test")ã�´�.
		//return "redirect:/test"; // request,response�� ���Ӱ� �����ؼ� @ReqeuestMapping("/test")ã�´�.
		
		return "redirect:/index.kosta";
	}
	
	
	/**
	 * �󼼺���
	 * */
	@RequestMapping("/read.kosta")
	public void read(String code, Model model) {
		ProductDTO dto = productService.read(code);
		model.addAttribute("product", dto);
	}
	
	/**
	 * �����ϱ�
	 * */
	@RequestMapping("/{code}")
	public String delete(@PathVariable String code) throws MyErrorException{
		productService.delete(code);
		
		return "redirect:/index.kosta";
	}
	
	
	@ExceptionHandler(value = {MyErrorException.class})
	public ModelAndView error(MyErrorException e) {
		
		return new ModelAndView("error", "errMessage", e.getMessage());
	}
	
}
