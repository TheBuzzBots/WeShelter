package edu.gatech.team10.weshelter;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Constructor;

import static org.junit.Assert.*;

public class ValidUserTest {
    private Model model;

    @Before
    public void setUp() throws Exception{
        Constructor<Model> c = Model.class.getDeclaredConstructor();
        c.setAccessible(true);
        model = c.newInstance();
        User[] testUsers = new User[6];
        testUsers[0] = new HomelessPerson("mark", "markiscool", "Mark");
        testUsers[1] = new HomelessPerson("john", "john12345", "John");
        testUsers[2] = new HomelessPerson("jacob", "jacobcute", "Jacob");
        testUsers[3] = new HomelessPerson("molly", "!molly!", "Molly");
        testUsers[4] = new HomelessPerson("lara", "lara!!1", "Lara");
        testUsers[5] = new HomelessPerson("paul", "paul1234", "Paul");
        for (User u : testUsers) {
            model.addUser(u.getUsername(), u);
        }
    }

    @Test
    public void testNullUser() {
        String user = null;
        String pass = null;
        boolean result = model.isValidUser(user, pass);
        assertEquals(result, false);
    }

    @Test
    public void testUnRegisteredUser() {
        boolean result = model.isValidUser("jesus", "jesusiscool");
        assertEquals(result, false);
    }

    @Test
    public void testRegisteredUser() {
        boolean result = model.isValidUser("mark", "markiscool");
        assertEquals(result, true);
    }

    @Test
    public void testUserWithInvalidPassword() {
        boolean result = model.isValidUser("jacob", "jacob");
        assertEquals(result, false);
    }

    @Test
    public void testUserWithValidPassword() {
        boolean result = model.isValidUser("molly", "!molly!");
        assertEquals(result, true);
    }
}
