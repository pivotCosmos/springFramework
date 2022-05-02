package kosta.mvc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kosta.mvc.dto.ProductDTO;
import kosta.mvc.exception.MyErrorException;

@Repository //���� - id="productDAOImpl"
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private List<ProductDTO> productList;
	
	@Override
	public List<ProductDTO> select() {
		return productList;
	}

	@Override
	public int insert(ProductDTO productDTO) throws MyErrorException {
		//��ǰ�ڵ尡 �ߺ����� üũ�Ѵ�. -read()�޼ҵ� Ȱ���Ѵ�.
		//�����ϸ� ���ܹ߻���Ų��.
		if( read(productDTO.getCode()) !=null) {
			throw new MyErrorException(productDTO.getCode()+"�� �̹� �����ϴ� ��ǰ�ڵ��Դϴ�.");
		}
		
		//�ߺ��ƴϸ� list�� �߰�
		productList.add(productDTO);
		
		return 1;
	}

	@Override
	public int delete(String code) throws MyErrorException {
		//code�� �����ϴ��� üũ�Ѵ�.
		ProductDTO product = read(code);
		if(product==null) throw new MyErrorException(code+"�� �߸��Ǿ� ������ �� �����ϴ�.");
		
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
