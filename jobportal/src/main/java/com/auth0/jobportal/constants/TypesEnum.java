package com.auth0.jobportal.constants;

public enum TypesEnum {
    POSTER("p"),SEEKER("s"),JOB("j");

    private String value;

    public String getValue(){
        return this.value;
    }

    TypesEnum(String type){
        this.value=type;
    }


}
