package pl.fissst.lbd.springrestlbd.filter;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;

@Component
@Order(1)
@WebFilter("/*")
//https://stackoverflow.com/questions/42857658/how-to-log-time-taken-by-rest-web-service-in-spring-boot
public class TimeFilter implements Filter {
    private static final Logger LOGGER = LoggerFactory.getLogger(TimeFilter.class);
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        Instant start = Instant.now();
        try {
            filterChain.doFilter(servletRequest, servletResponse);
        } finally {
            Instant finish = Instant.now();
            long time = Duration.between(start, finish).toMillis();
            LOGGER.info("{}: {} ms ", ((HttpServletRequest) servletRequest).getRequestURI(),  time);
        }
    }
}
