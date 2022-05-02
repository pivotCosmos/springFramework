package kosta.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kosta.mvc.dao.ProductDAO;
import kosta.mvc.dto.ProductDTO;
import kosta.mvc.exception.MyErrorException;

@Service //id="productServiceImpl" - ����
public class ProductServiceImpl implements ProductService {

	@Autowired //����
	private ProductDAO productDAO;
	
	private final static int MIN_PRICE=1000;
	private final static int MAX_PRICE=10000;
	
	@Override
	public List<ProductDTO> select() {
		//DAO�� �޼ҵ� ȣ��
		List<ProductDTO> productList = productDAO.select();
		return productList;
	}

	@Override
	public int insert(ProductDTO productDTO) throws MyErrorException {
		//������ ���� üũ (1000 ~ 10000����)�ؼ� ������ �ƴϸ� ���ܹ߻���Ų��.
		if(productDTO.getPrice()<MIN_PRICE || productDTO.getPrice()>MAX_PRICE) {
			throw new MyErrorException("������ " + MIN_PRICE + " ~ " + MAX_PRICE + "������ �Է��ϼ���.");
		}
		
		//daoȣ��
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
