package jp.co.aforce.beans;

public class Product implements java.io.Serializable {

		private int id;
		private String productName;
		private int price;
		
		public Product(int id, String productName, int price) {
			this.id=id;
			this.productName=productName;
			this.price=price;
		}
		
		public Product() {};
		
		public int getId() {
			return id;
		}
		
		public String getProductName() {
			return productName;
		}
		
		public int getPrice() {
			return price;
		}
		
		public void setId(int id) {
			this.id=id;
		}
		
		public void setProductName(String productName) {
			this.productName=productName;
		}
		
		public void setPrice(int price) {
			this.price=price;
		}
}
