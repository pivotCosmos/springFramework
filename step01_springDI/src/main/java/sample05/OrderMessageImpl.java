package sample05;

public class OrderMessageImpl implements OrderMessage {
	private int orderId;
	private String message;
	
	private UserBean userbean;
	private ProductBean productBean;
	

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public UserBean getUserbean() {
		return userbean;
	}

	public void setUserbean(UserBean userbean) {
		this.userbean = userbean;
	}

	public ProductBean getProductBean() {
		return productBean;
	}

	public void setProductBean(ProductBean productBean) {
		this.productBean = productBean;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public void getOrderMessage() {
		StringBuilder sb = new StringBuilder();
		sb.append("orderId : " + orderId);
		sb.append("\nname : " + userbean.getName());
		sb.append("\nphone : " + userbean.getPhone());
		sb.append("\nproductName : " + productBean.getProductName());
		sb.append("\nproductPrice : " + productBean.getProductPrice());
		sb.append("\nmessage : " + message);
		System.out.println(sb);
	}
}
