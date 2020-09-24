package com.zy.ok.service;

public class OkService {

    public String describe;

    public OkService(String describe) {
        this.describe = describe;
    }

    public String okDescribe(){
        return this.describe;
    }
}
