package org.fpm.di.example;

import org.fpm.di.Binder;
import org.fpm.di.Container;
import org.fpm.di.Environment;
import org.fpm.di.MyBinder;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Example {

    private Container container;
    private Binder binder;  // Assuming you have a Binder class


    @Test
    public void output(){
        System.out.println("Singleton should be same ");
        System.out.println(container.getComponent(MySingleton.class));
        System.out.println(container.getComponent(MySingleton.class));
        System.out.println("=======================================");

        System.out.println("Prototype should be different ");
        System.out.println(container.getComponent(MyPrototype.class));
        System.out.println(container.getComponent(MyPrototype.class));
        System.out.println("=======================================");

        System.out.println("A should return instance of B ");
        System.out.println(container.getComponent(A.class));
        System.out.println("=======================================");

        System.out.println("B should be same ( and save as A )");
        System.out.println(container.getComponent(B.class));
        System.out.println(container.getComponent(B.class));
        System.out.println("=======================================");

        System.out.println("UseA dependency should return instance of A which instance of B ");
        System.out.println(container.getComponent(UseA.class));
        System.out.println(container.getComponent(UseA.class).getDependency());
        System.out.println("=======================================");
    }


    @Before
    public void setUp() {
        Environment env = new DummyEnvironment();
        binder = new MyBinder();  // Instantiate your concrete binder
        container = env.configure(new MyConfiguration());
    }

    @Test
    public void shouldInjectSingleton() {
        assertSame(container.getComponent(MySingleton.class), container.getComponent(MySingleton.class));
    }

    @Test
    public void shouldInjectPrototype() {
        assertNotSame(container.getComponent(MyPrototype.class), container.getComponent(MyPrototype.class));
    }

    @Test
    public void shouldBuildInjectionGraph() {

        binder.bind(A.class, B.class);
        binder.bind(B.class, new B());

        final B bAsSingleton = container.getComponent(B.class);
        assertSame(container.getComponent(A.class), bAsSingleton);
        assertSame(container.getComponent(B.class), bAsSingleton);
    }

    @Test
    public void shouldBuildInjectDependencies() {
        final UseA hasADependency = container.getComponent(UseA.class);
        assertSame(hasADependency.getDependency(), container.getComponent(B.class));
    }
}
