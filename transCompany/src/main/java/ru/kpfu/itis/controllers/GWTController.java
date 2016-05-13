package ru.kpfu.itis.controllers;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by evdodima on 13/05/16.
 * 11-402
 */
public abstract class GWTController extends RemoteServiceServlet
        implements Controller, ServletContextAware {

    private ServletContext servletContext;

    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    public ServletContext getServletContext() {
        return servletContext;
    }

    public ModelAndView handleRequest(HttpServletRequest request,
                                      HttpServletResponse response) throws Exception {
        super.doPost(request, response);
        return null;
    }



}
