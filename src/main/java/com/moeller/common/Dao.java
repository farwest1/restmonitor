package com.moeller.common;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Stereotype;
import javax.inject.Named;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by Bernd on 27.08.2016.
 */
@ApplicationScoped
@Stereotype
@Named
@Target(TYPE)
@Retention(RUNTIME)
public @interface Dao {
}
