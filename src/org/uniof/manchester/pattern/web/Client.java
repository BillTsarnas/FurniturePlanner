package org.uniof.manchester.pattern.web;

public class Client {
	private int clientId;
	private String name;
	private String surname;
	private String mphone;
	private String hphone;
	private String email;
	private String address;
	
	
	
	public Client(int clientId, String name, String surname, String mphone, String hphone, String email,
			String address) {
		super();
		this.clientId = clientId;
		this.name = name;
		this.surname = surname;
		this.mphone = mphone;
		this.hphone = hphone;
		this.email = email;
		this.address = address;
	}
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getMphone() {
		return mphone;
	}
	public void setMphone(String mphone) {
		this.mphone = mphone;
	}
	public String getHphone() {
		return hphone;
	}
	public void setHphone(String hphone) {
		this.hphone = hphone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	

}
