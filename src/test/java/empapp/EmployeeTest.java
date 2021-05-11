package empapp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    @Test
    void testGetAge() {


    assertEquals(70, new Employee("Jhon Doe", 1950).getAge(2020));
    }
}