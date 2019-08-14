package com.ecm.common;

public enum StatusEnum {
	Active("Active"), In_Active("In-Active");
    private String id;

    private StatusEnum(String id) {
        this.id = id;

    }

    public String getId() {
        return id;
    }
}
