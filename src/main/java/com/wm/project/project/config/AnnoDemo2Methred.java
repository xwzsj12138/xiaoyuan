package com.wm.project.project.config;




import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface AnnoDemo2Methred {

    String name() default "";

    String classname() default  "";

    String id() default "";

}
