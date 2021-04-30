import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.*;
import test.*;

public class ReflectionDemo {
    public static int getSumOfHumans(List<?> list){
        int sum = 0;
        for(Object value : list){
            if(value instanceof  Human){
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
    public static int sumOfExecutables(List<?> list) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException
    {
        int sum = 0;
        for(Object obj : list){
            if(test.Executable.class.isAssignableFrom(obj.getClass())){
                sum++;
                obj.getClass().getMethod("execute").invoke(obj);
                //((Executable) obj).execute();
            }
        }
        return sum;
    }
    public static List<String> getGetters(Class<?> obj){
        List<String> result = new ArrayList<>();
        for(Method method : obj.getMethods()){
            if(!method.getName().equals("getClass"))
            {
                if (method.getName().startsWith("get") && !method.getReturnType().getName().equals("void") && method.getParameterCount() == 0 && !Modifier.isStatic(method.getModifiers()))
                {
                    result.add(method.getName());
                }
            }
        }
        return result;
    }
    public static List<String> getSetters(Class<?> obj){
        List<String> result = new ArrayList<>();
        for(Method method : obj.getMethods()) {
            if (method.getName().startsWith("set") && method.getReturnType().getName().equals("void") && method.getParameterCount() ==1 && !Modifier.isStatic(method.getModifiers()))
            {
                result.add(method.getName());
            }
        }
        return result;
    }
    public static List<String> getGettersAndSetters(Class<?> obj){
        List<String> result = new ArrayList<>();
        result.addAll(getGetters(obj));
        result.addAll(getSetters(obj));
        return result;
    }
}
