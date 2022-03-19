package com.fundamentosplatzi.springboot.fundamentos;

import com.fundamentosplatzi.springboot.fundamentos.bean.MyBean;

public class MyBean2Implement implements MyBean {
    @Override
    public void print() {
        System.out.println("Hola desde mi implementacion propia del bean 2");
    }
}
