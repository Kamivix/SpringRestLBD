package pl.fissst.lbd.springrestlbd.filter;

import org.springframework.http.MediaType;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthorizationTeacherFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        String role = httpRequest.getHeader("role");

        if ((!role.equals("TEACHER_ROLE"))) {
            HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
            httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            httpResponse.setContentType(MediaType.APPLICATION_JSON.toString());
            httpResponse.getWriter().write("{\"errorMessage\": \"User unauthorized!\"}");

            return;
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }
    }

