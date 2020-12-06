////////////////////////////////////////////////////////////////////
// Andrea Breggion 1192760
////////////////////////////////////////////////////////////////////
package it.unipd.tos.model;

public class User {
    String id;
    String name;
    String surname;
    int age;
    public User(String i, String n, String s, int a) {
        id = i;
        name = n;
        surname = s;
        age = a;
    }
    public String getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getSurname(){
        return surname
    }

    public int getAge(){
        return age;
    }

    public boolean isMinorenne(){
        return age<18;
    }

}
