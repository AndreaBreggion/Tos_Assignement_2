package it.unipd.tos.model;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UserTest {
    User user;
    @Before
    public void Setup(){
        user = new User("001","General","Buttnaked",43);
    }
    @Test
    public void getIdTest(){
        Assert.assertEquals("001",user.getId());
    }
    @Test
    public void getNameTest(){
        Assert.assertEquals("General",user.getName());
    }
    @Test
    public void getSurnameTest(){
        Assert.assertEquals("Buttnaked",user.getSurname());
    }
    @Test
    public void getAgeTest(){
        Assert.assertEquals(43,user.getAge());
    }
}
