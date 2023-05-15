package com.desapex.spacemanager.resource.dto;


public class DepartmentDto {

    public Long id;
    public String name;
    public Long credit;

    public DepartmentDto(Long id, String name, Long credit) {
        this.id = id;
        this.name = name;
        this.credit = credit;
    }

    public DepartmentDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCredit() {
        return credit;
    }

    public void setCredit(Long credit) {
        this.credit = credit;
    }

    @Override
    public String toString() {
        return "DepartmentDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", credit=" + credit +
                '}';
    }


}

