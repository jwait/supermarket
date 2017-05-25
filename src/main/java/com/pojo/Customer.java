package com.pojo;

public class Customer {
    private Integer id;

    private String username;

    private String nickname;

    private String sex;

    private String email;

    private String phone;

    private String isdelete;
    
    private CustomerLogin customerLogin;
    
    private Getadress getadress;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(String isdelete) {
        this.isdelete = isdelete == null ? null : isdelete.trim();
    }

	public CustomerLogin getCustomerLogin() {
		return customerLogin;
	}

	public void setCustomerLogin(CustomerLogin customerLogin) {
		this.customerLogin = customerLogin;
	}

	public Getadress getGetadress() {
		return getadress;
	}

	public void setGetadress(Getadress getadress) {
		this.getadress = getadress;
	}
    
    
}