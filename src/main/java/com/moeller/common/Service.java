package com.moeller.common;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Stereotype;
import javax.inject.Named;
import javax.transaction.Transactional;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by Bernd on 27.08.2016.
 */
@ApplicationScoped
@Stereotype
@Named
@Transactional
@Target(TYPE)
@Retention(RUNTIME)
public @interface Service {
}
