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

@Controller //생성 id="productController"
public class ProductController {
	
	@Autowired //주입
	private ProductService productService;
	
	@RequestMapping("/index.kosta")
	public String index(Model model) {
		
		List<ProductDTO> productList = productService.select();
		model.addAttribute("productList", productList); //뷰에서 ${productList} 사용
		
		return "productList"; //WEB-INF/views/productList.jsp이동
	}
	
	/**
	 * 등록폼
	 * */
	//@RequestMapping("/insertForm.kosta")
	@RequestMapping("/{url}.kosta")
	public void form() {
		
	}
	
	
	/**
	 * 등록하기
	 * */
	//@RequestMapping("/insert.kosta")
	@PostMapping("/insert.kosta")
	public String insert(ProductDTO productDTO) throws MyErrorException{
		
		productService.insert(productDTO);
		
		//return "test"; //리턴값이 뷰이름이 된다.
		//return "forward:/test"; // request,response를 유지하면서 @ReqeuestMapping("/test")찾는다.
		//return "redirect:/test"; // request,response를 새롭게 생성해서 @ReqeuestMapping("/test")찾는다.
		
		return "redirect:/index.kosta";
	}
	
	
	/**
	 * 상세보기
	 * */
	@RequestMapping("/read.kosta")
	public void read(String code, Model model) {
		ProductDTO dto = productService.read(code);
		model.addAttribute("product", dto);
	}
	
	/**
	 * 삭제하기
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
