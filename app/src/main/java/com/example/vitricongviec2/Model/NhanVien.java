package com.example.vitricongviec2.Model;

public class NhanVien {
    private int id;
    private String name, dob, address, level;

    public NhanVien() {
    }

    public NhanVien(int id, String name, String dob, String address, String level) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.address = address;
        this.level = level;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
