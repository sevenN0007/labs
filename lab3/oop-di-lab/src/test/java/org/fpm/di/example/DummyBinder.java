package org.fpm.di.example;

import org.fpm.di.Binder;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Parameter;
import java.util.HashMap;

public class DummyBinder implements Binder {

    private final HashMap<Class, Object> objectsInstances= new HashMap<Class,Object>();

    public HashMap<Class, Object> getObjectsInstances(){
        return objectsInstances;
    }
    @Override
    //Перевіряє, чи існують конструктори класу, які анотовані @Inject та створює екземпляр класу
    //Якщо клас має анотацію @Singleton, зберігає створений екземпляр в мапі
    public <T> void bind(Class<T> clazz) {
        try {
            T set_in_list_object = null;

            boolean test_inject = false;
            Constructor<?>[] constructors = clazz.getConstructors();
            for (Constructor<?> constructor: constructors){
                if(null != constructor.getAnnotation(Inject.class)) {
                    test_inject = true;

                    Parameter[] parameters = constructor.getParameters();
                    Object[] list_of_param = new Object[parameters.length];
                    for (int i = 0; i < parameters.length; i++){

                        Class class_name = parameters[i].getType();

                        if (objectsInstances.containsKey(class_name)){
                            list_of_param[i] = objectsInstances.get(class_name);}
                        else {
                            list_of_param[i] = class_name.newInstance();
                        }

                    }
                    set_in_list_object = (T) constructor.newInstance(list_of_param);
                }
            }
            if (set_in_list_object==null){
                set_in_list_object = (T) clazz.newInstance();
            }
            boolean test_singleton = false;
            for (Annotation annotation: clazz.getDeclaredAnnotations()){
                if (annotation.annotationType() == Singleton.class){
                    test_singleton= true;
                }
            }
            if (test_singleton){
                objectsInstances.put(clazz, set_in_list_object);
            }
            else {
                objectsInstances.put(clazz,null);
            }
        }
        catch (Exception ie){
            System.out.println((ie));
            System.out.println("Error 00000");
        }
    }

    @Override
    //Перевіряє, чи існує екземпляр прив'язаного класу (implementation) в мапі.
    //Якщо так, прив'язує цей екземпляр до класу clazz.
    public <T> void bind(Class<T> clazz, Class<? extends T> implementation) {
        if (objectsInstances.containsKey(implementation)){
            objectsInstances.put(clazz,objectsInstances.get(implementation) );
        }
    }

    @Override
    //Просто прив'язує вказаний екземпляр до класу clazz.
    public <T> void bind(Class<T> clazz, T instance) {
        objectsInstances.put(clazz,instance);
    }
}
