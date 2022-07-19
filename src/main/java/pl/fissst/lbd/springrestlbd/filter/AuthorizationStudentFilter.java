package pl.fissst.lbd.springrestlbd.filter;

import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthorizationStudentFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {;




            HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
            String role = httpRequest.getHeader("role");

            if ((role==null) || (!role.equals("STUDENT_ROLE")) && (!role.equals("TEACHER_ROLE"))) {
                HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
                httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                httpResponse.setContentType(MediaType.APPLICATION_JSON.toString());
                httpResponse.getWriter().write("{\"errorMessage\": \"User unauthorized!\"}");

                return;
            }

            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

