import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.*;
import test.*;

public class ReflectionDemo {
    public static int getSumOfHumans(List<?> list){
        int sum = 0;
        for(Object value : list){
            if(value.getClass().getName().equals("Human") || value.getClass().isAssignableFrom(Human.class)){
                sum++;
            }
        }
        return sum;
    }
    public static List<Method> getPublicMethods(Class<?> object){
        return new ArrayList<>(Arrays.asList(object.getMethods()));
    }
    public static List<String> getSuperClasses(Class<?> object){
        Class<?> temp = object.getSuperclass();
        List<String> list = new ArrayList<>();
        while(temp!=null){
            list.add(temp.getName());
            temp = temp.getSuperclass();
        }
        return list;
    }
    public static int sumOfExecutables(List<Class<?>> list){
        int sum = 0;
        for(Class<?> obj : list){
            sum+=Executable.class.isAssignableFrom(obj) ? 1 : 0;
        }
        return sum;
    }
    public static List<String> getGetters(Class<?> obj){
        List<String> result = new ArrayList<>();
        for(Method method : obj.getMethods()){
            if(!method.getReturnType().getName().equals("void")&&method.getParameterCount()==0 && !Modifier.isStatic(method.getModifiers())){
                result.add(method.getName());
            }
        }
        return result;
    }
    public static List<String> getSetters(Class<?> obj){
        List<String> result = new ArrayList<>();
        for(Method method : obj.getMethods()) {
            if(method.getReturnType().getName().equals("void")&&method.getParameterCount()>0&&!Modifier.isStatic(method.getModifiers())){
                result.add(method.getName());
            }
        }
        return result;
    }
}
