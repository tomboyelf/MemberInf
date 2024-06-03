package jp.co.aforce.beans;

public class Customer implements java.io.Serializable {

		private int id;
		private String username;
		private String password;
		private String lastname;
		private String firstname;
		private String sex;
		private String birth;
		private String mail;
		private int phone;
		
		public Customer(int id, String username, String password, String lastname, String firstname, String sex, String birth, String mail, int phone) {
			this.id=id;
			this.username=username;
			this.password=password;
			this.lastname=lastname;
			this.firstname=firstname;
			this.sex=sex;
			this.birth=birth;
			this.mail=mail;
			this.phone=phone;
		}
		
		public Customer() {};
		
		public int getId() {
			return id;
		}
		
		public String getUsername() {
			return username;
		}
		
		public String getPassword() {
			return password;
		}
	
		public String getLastname() {
			return lastname;
		}
		public String getFirstname() {
			return firstname;
		}
		public String getSex() {
			return sex;
		}
		public String getBirth() {
			return birth;
		}
		public String getMail() {
			return mail;
		}
		
		public int getPhone() {
			return phone;
		}
//		public void setId(int id) {
//			this.id=id;
//		}
//		
		public void setUsername(String username) {
			this.username=username;
		}
		
		public void setPassword(String password) {
			this.password=password;
		}
}
