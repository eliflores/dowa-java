package com.dowa.web;

import javax.faces.context.FacesContext;

public class JsfUtil {

    private JsfUtil() {
    }

    public static <T> T getBean(final String beanName, final FacesContext facesContext) {
        final Object returnObject = facesContext.getELContext().getELResolver().getValue(facesContext.getELContext(), null, beanName);
        if (returnObject == null) {
            throw new RuntimeException("Couldn't get bean named: " +  beanName);
        }
        return (T) returnObject;
    }
}
