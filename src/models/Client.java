package models;

import java.util.List;

public class Client {
    private String name;
    private String dni;
    private String address;
    private Long phone;

    public Client() {
    }

    public Client(String name, String dni, String address, Long phone) {
        this.name = name;
        this.dni = dni;
        this.address = address;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

}
