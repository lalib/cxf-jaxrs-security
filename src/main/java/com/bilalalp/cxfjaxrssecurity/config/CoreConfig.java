package com.bilalalp.cxfjaxrssecurity.config;

import lombok.Getter;
import lombok.Setter;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

@ComponentScan(value = {"com.bilalalp.cxfjaxrssecurity"})
@Getter
@Setter
@Configuration
public class CoreConfig implements WebApplicationInitializer {

    @Override
    public void onStartup(final ServletContext servletContext) throws ServletException {
        final AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(CoreConfig.class, WebServiceConfig.class, SecurityConfig.class, CachingConfig.class);
        servletContext.addListener(new ContextLoaderListener(ctx));

        final FilterRegistration.Dynamic securityFilter = servletContext.addFilter("springSecurityFilterChain", DelegatingFilterProxy.class);
        securityFilter.addMappingForUrlPatterns(null, false, "/*");

        final ServletRegistration.Dynamic servlet = servletContext.addServlet("CXFServlet", new CXFServlet());
        servlet.setLoadOnStartup(1);
        servlet.addMapping("/*");
    }
}