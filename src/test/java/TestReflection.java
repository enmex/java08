import org.junit.Test;
import test.*;

import java.lang.reflect.Method;
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
        System.out.println(ReflectionDemo.getPublicMethods(Human.class));
        assertEquals(14, ReflectionDemo.getPublicMethods(Human.class).size());
    }
    @Test
    public void getSuperClasses(){
        assertEquals(2, ReflectionDemo.getSuperClasses(Human.class).size());
    }
    @Test
    public void testSumOfExecutables(){

    }
}
