package pl.fissst.lbd.springrestlbd.configuration;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.fissst.lbd.springrestlbd.filter.AuthorizationStudentFilter;

@Configuration
public class FilterConfiguration {
    @Bean
    public FilterRegistrationBean<AuthorizationStudentFilter> loggingFilter(){
        FilterRegistrationBean<AuthorizationStudentFilter> registrationBean = new FilterRegistrationBean<>();

        registrationBean.setFilter(new AuthorizationStudentFilter());
        registrationBean.addUrlPatterns("/api/student/*");
        registrationBean.setOrder(1);
        return registrationBean;
    }
}
