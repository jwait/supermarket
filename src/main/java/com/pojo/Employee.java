package com.pojo;

public class Employee {
    private Integer id;

    private String eid;

    private String name;

    private String phone;

    private String email;

    private EmployeeLimit employeeLimit;

    private String password;

    private String isdelete;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEid() {
        return eid;
    }

    public void setEid(String eid) {
        this.eid = eid == null ? null : eid.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }
    
    public EmployeeLimit getEmployeeLimit() {
		return employeeLimit;
	}

	public void setEmployeeLimit(EmployeeLimit employeeLimit) {
		this.employeeLimit = employeeLimit;
	}

	public String getPassword() {
        return password;
    }
	
	public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }
	
	public String getIsdelete() {
		return isdelete;
	}

	public void setIsdelete(String isdelete) {
		this.isdelete = isdelete;
	}

	
}