package in.joshi.dto;

public class Student {
	
	
	
	private Integer sid;
	private String name;
	private String email; 
	private String city;
	private String country;
	
	public Student() {
		System.out.println("Student Object Created");
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Integer getSid() {
		return sid;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public String getCity() {
		return city;
	}
	public String getCountry() {
		return country;
	}
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", name=" + name + ", email=" + email + ", city=" + city + ", country=" + country
				+ "]";
	}
}
