package org.fpm.di.example;

import org.fpm.di.Configuration;
import org.fpm.di.Container;
import org.fpm.di.Environment;

public class DummyEnvironment implements Environment {

    @Override
    public Container configure(Configuration configuration) {
        // Ваш код конфігурації, якщо він потрібен
        // Наприклад, можна використовувати переданий configuration для конфігурації біндера
        DummyBinder binder = new DummyBinder();
        configuration.configure(binder);

        // Повертаємо контейнер з конфігурованим біндером
        return new DummyContainer(binder);
    }
}
