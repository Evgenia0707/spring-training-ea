package com.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})//java lang//can put annot on top on ()s
@Retention(RetentionPolicy.RUNTIME)//read annot in run time
public @interface LoggingAnnotation {

}
