package com.sarthak.student_api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name cannot be empty")
    @Size(min = 2,max = 50,message = "Name must be between 2 to 50 characters")
    private String name;

    @NotBlank(message = "Email cannot be empty")
    @Email(message = "Please provide a valid email")
    private String email;

    @NotBlank(message = "Branch cannot be empty")
    @Size(min = 2,max = 30,message = "Branch must be between  2 to 30 characters")
    private String branch;

    public Student(){}

    public Student(String name,String email,String branch){
            this.name = name;
            this.email = email;
            this.branch = branch;
    }

        public Long getId(){return id;}
        public void setId(Long id){this.id = id;}

        public String getName(){return name;}
        public void setName(String name){this.name = name;}

        public String getEmail(){return email;}
        public void setEmail(String email){this.email = email;}

        public String getBranch(){return branch;}
        public void setBranch(String branch){this.branch = branch;}
}
