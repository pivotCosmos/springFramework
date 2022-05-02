package kosta.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kosta.mvc.dao.ProductDAO;
import kosta.mvc.dto.ProductDTO;
import kosta.mvc.exception.MyErrorException;

@Service //id="productServiceImpl" - 생성
public class ProductServiceImpl implements ProductService {

	@Autowired //주입
	private ProductDAO productDAO;
	
	private final static int MIN_PRICE=1000;
	private final static int MAX_PRICE=10000;
	
	@Override
	public List<ProductDTO> select() {
		//DAO의 메소드 호출
		List<ProductDTO> productList = productDAO.select();
		return productList;
	}

	@Override
	public int insert(ProductDTO productDTO) throws MyErrorException {
		//가격의 범위 체크 (1000 ~ 10000사이)해서 범위가 아니면 예외발생시킨다.
		if(productDTO.getPrice()<MIN_PRICE || productDTO.getPrice()>MAX_PRICE) {
			throw new MyErrorException("가격은 " + MIN_PRICE + " ~ " + MAX_PRICE + "내에서 입력하세요.");
		}
		
		//dao호출
		int result = productDAO.insert(productDTO);
		return result;
	}

	@Override
	public int delete(String code) throws MyErrorException {
		int result = productDAO.delete(code);
		return result;
	}

	@Override
	public ProductDTO read(String code) {
		ProductDTO dto = productDAO.read(code);
		
		return dto;
	}

}
