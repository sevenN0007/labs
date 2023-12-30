package org.fpm.di.example;

import org.fpm.di.Container;

public class DummyContainer implements Container {

    private final DummyBinder binder;

    public DummyContainer(DummyBinder binder) {
        this.binder = binder;
    }

    @Override
    public <T> T getComponent(Class<T> clazz) {
        if (binder.getObjectsInstances().containsKey(clazz)) {
            Object instance = binder.getObjectsInstances().get(clazz);

            // Якщо екземпляр не було створено, спробуйте створити новий
            if (instance == null) {
                try {
                    instance = clazz.newInstance();
                } catch (InstantiationException | IllegalAccessException e) {
                    e.printStackTrace();
                    return null;
                }
            }

            // Зберігаємо екземпляр в мапі, навіть якщо це null (значить, це новий екземпляр)
            binder.getObjectsInstances().put(clazz, instance);

            return (T) instance;
        } else {
            // Якщо клас не знайдено в мапі, створюємо новий екземпляр та зберігаємо його в мапі
            try {
                T instance = clazz.newInstance();
                binder.getObjectsInstances().put(clazz, instance);
                return instance;
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
                return null;
            }
        }
    }

}
