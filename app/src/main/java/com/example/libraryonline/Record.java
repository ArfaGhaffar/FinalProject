package com.example.libraryonline;

public class Record {
    private String id;
    private  String name;
    private  String department;
    private  String book_name;
    private  String usn;

    public Record(String id, String name, String department, String book_name, String usn) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.book_name = book_name;
        this.usn = usn;
    }

    public  Record(){

    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsn() {
        return usn;
    }

    public void setUsn(String usn) {
        this.usn = usn;
    }
}
