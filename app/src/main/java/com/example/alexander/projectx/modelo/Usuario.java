package com.example.alexander.projectx.modelo;

import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;

import java.util.Hashtable;

public class Usuario implements KvmSerializable {

    private String UserName;
    private String UserPass;


    public Usuario(){

    }

    public Usuario(String userName, String userPass){
        this.UserName = userName;
        this.UserPass = userPass;
    }

    public String getUserName(){return UserName;}
    public void setUserName() {this.UserName = UserName;}
    public String getUserPass() {return UserPass;}
    public void setUserPass() {this.UserPass = UserPass;}

    @Override
    public Object getProperty(int i) {
        switch (i){
            case 0: return this.UserName;
            case 1: return this.UserPass;
        }
        return null;
    }

    @Override
    public int getPropertyCount() {
        return 2;
    }

    @Override
    public void setProperty(int i, Object o) {
        switch (i){
            case 0: this.UserName = o.toString();break;
            case 1: this.UserPass = o.toString();break;
        }
    }

    @Override
    public void getPropertyInfo(int i, Hashtable hashtable, PropertyInfo propertyInfo) {

    }

    @Override
    public String getInnerText() {
        return null;
    }

    @Override
    public void setInnerText(String s) {

    }
}
