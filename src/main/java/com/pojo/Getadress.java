package com.pojo;

public class Getadress {
    private Integer id;

    private String adress;

    private Integer customerId;

    private String getname;

    private String getphone;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress == null ? null : adress.trim();
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getGetname() {
        return getname;
    }

    public void setGetname(String getname) {
        this.getname = getname == null ? null : getname.trim();
    }

    public String getGetphone() {
        return getphone;
    }

    public void setGetphone(String getphone) {
        this.getphone = getphone == null ? null : getphone.trim();
    }
}