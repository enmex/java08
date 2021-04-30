import org.junit.Test;
import test.*;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

import static org.junit.Assert.*;

public class TestReflection {
    @Test
    public void testGetSumOfHumans(){
        List<Human> list = new ArrayList<>(3);
        list.add(new Human("", "", "", ""));
        list.add(new Human("", "", "", ""));
        list.add(new Human("", "", "", ""));

        List<String> list1 = new ArrayList<>(3);
        list1.add("");
        list1.add("");
        list1.add("");

        assertEquals(3, ReflectionDemo.getSumOfHumans(list));
        assertEquals(0, ReflectionDemo.getSumOfHumans(list1));
    }
    @Test
    public void tesGetPublicMethods(){
        assertEquals(15, ReflectionDemo.getPublicMethods(Human.class).size());
    }
    @Test
    public void getSuperClasses(){
        assertEquals(2, ReflectionDemo.getSuperClasses(Human.class).size());
    }
    @Test
    public void testSumOfExecutables() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException
    {//
        List<Human> list = new ArrayList<>(3);
        list.add(new Human("", "", "", ""));
        list.add(new Human("", "", "", ""));
        list.add(new Human("", "", "", ""));

        List<String> list1 = new ArrayList<>(3);
        list1.add("");
        list1.add("");
        list1.add("");

        List<Flat> list2 = new ArrayList<>(3);
        list2.add(new Flat());
        list2.add(new Flat());
        list2.add(new Flat());

        assertEquals(3, ReflectionDemo.sumOfExecutables(list2));
        assertEquals(0, ReflectionDemo.sumOfExecutables(list1));
        assertEquals(3, ReflectionDemo.sumOfExecutables(list));
    }
    @Test
    public void testGetGetters(){
        assertEquals(4, ReflectionDemo.getGetters(House.class).size());
    }
    @Test
    public void testSetSetters(){
        List<String> list = ReflectionDemo.getSetters(House.class);
        assertEquals(1, ReflectionDemo.getSetters(House.class).size());
    }
    @Test
    public void testGetSettersAndGetters(){
        assertEquals(5, ReflectionDemo.getGettersAndSetters(House.class).size());
    }
}
