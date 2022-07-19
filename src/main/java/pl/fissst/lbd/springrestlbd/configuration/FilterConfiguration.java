package pl.fissst.lbd.springrestlbd.configuration;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.fissst.lbd.springrestlbd.filter.AuthorizationStudentFilter;
import pl.fissst.lbd.springrestlbd.filter.AuthorizationTeacherFilter;

@Configuration
public class FilterConfiguration {
//    @Bean
//    public FilterRegistrationBean<AuthorizationStudentFilter> AuthorizationStudentFilterConfig(){
//        FilterRegistrationBean<AuthorizationStudentFilter> registrationBean = new FilterRegistrationBean<>();
//
//        registrationBean.setFilter(new AuthorizationStudentFilter());
//        registrationBean.addUrlPatterns("/api/student/*");
//        registrationBean.setOrder(2);
//        return registrationBean;
//    }
//@Bean
//    public FilterRegistrationBean<AuthorizationTeacherFilter> AuthorizationTeacherFilterConfig(){
//        FilterRegistrationBean<AuthorizationTeacherFilter> registrationBean = new FilterRegistrationBean<>();
//
//        registrationBean.setFilter(new AuthorizationTeacherFilter());
//        registrationBean.addUrlPatterns("/api/teacher/*");
//        registrationBean.setOrder(2);
//        return registrationBean;
//    }



}
