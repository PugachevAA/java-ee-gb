package ru.gb.lesson2.hello;


import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import javax.annotation.PostConstruct;
import java.lang.reflect.Field;
import java.util.Random;

@Component
public class InjectFoodStuffAnnotationBeanPostProcessor implements BeanPostProcessor {

    @Autowired
    Environment environment;

    String[] food;

    @PostConstruct
    public void init() {
        food = environment.getProperty("listOfFoodStuff").split(",");
    }
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        Field[] fields = bean.getClass().getDeclaredFields();

        for (Field field : fields) {
            InjectFoodStuff annotation = field.getAnnotation(InjectFoodStuff.class);
            if (annotation != null) {
                Random random = new Random();
                String foodStuff = food[random.nextInt(food.length - 1)];
                field.setAccessible(true);
                ReflectionUtils.setField(field, bean, foodStuff);
            }
        }

        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }
}
