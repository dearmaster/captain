package com.leaf.captain.blog;

import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.HashSet;

@Configuration
@EnableWebMvc
public class WebMvcConfigurer extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/hello").setViewName("hello");
        registry.addViewController("/login").setViewName("login");

        registry.addViewController("/404").setViewName("error-page-not-found");
        registry.addViewController("/500").setViewName("error-internal");
    }

//    @Bean
//    public ViewResolver viewResolver() {
//        InternalResourceViewResolver resolver=new InternalResourceViewResolver();
//        resolver.setPrefix("/templates/");
//        resolver.setSuffix(".html");
//        resolver.setExposeContextBeansAsAttributes(true);
//        return resolver;
//    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }

    @Bean
    public EmbeddedServletContainerCustomizer containerCustomizer() {

        return (container) -> {
                ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/404");
                ErrorPage innerErrorPage = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR,"/500");
                container.addErrorPages(error404Page);
                //container.addErrorPages(innerErrorPage);
                container.setErrorPages(new HashSet<ErrorPage>() {{
                    add(error404Page);
                    add(innerErrorPage);
                }});
        };

    }

}