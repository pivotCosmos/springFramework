package kosta.mvc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kosta.mvc.dto.ProductDTO;
import kosta.mvc.exception.MyErrorException;

@Repository //생성 - id="productDAOImpl"
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private List<ProductDTO> productList;
	
	@Override
	public List<ProductDTO> select() {
		return productList;
	}

	@Override
	public int insert(ProductDTO productDTO) throws MyErrorException {
		//상품코드가 중복인지 체크한다. -read()메소드 활용한다.
		//존재하면 예외발생시킨다.
		if( read(productDTO.getCode()) !=null) {
			throw new MyErrorException(productDTO.getCode()+"는 이미 존재하는 상품코드입니다.");
		}
		
		//중복아니면 list에 추가
		productList.add(productDTO);
		
		return 1;
	}

	@Override
	public int delete(String code) throws MyErrorException {
		//code가 존재하는지 체크한다.
		ProductDTO product = read(code);
		if(product==null) throw new MyErrorException(code+"가 잘못되어 삭제할 수 없습니다.");
		
		productList.remove(product);
		return 1;
	}

	@Override
	public ProductDTO read(String code) {
		for(ProductDTO dto : productList) {
			if(dto.getCode().equals(code)) {
				return dto;
			}
		}
		
		return null;
	}

}
