package pl.fissst.lbd.springrestlbd.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import pl.fissst.lbd.springrestlbd.interceptor.AuthorizeInterceptor;

@Component
public class InterceptorConfiguration implements WebMvcConfigurer {

        AuthorizeInterceptor authorizeInterceptor;
@Autowired
    public InterceptorConfiguration(AuthorizeInterceptor authorizeInterceptor) {
        this.authorizeInterceptor = authorizeInterceptor;
    }

    @Override
        public void addInterceptors(InterceptorRegistry registry) {
            registry.addInterceptor(authorizeInterceptor);
        }
    }

