package pl.fissst.lbd.springrestlbd.services;

import org.springframework.stereotype.Service;

@Service
public class AuthorizationService {

    public boolean isAuthorized(String uri, String role){

        if(uri==null || role==null){
            return false;
        }

        if(uri.startsWith("/api/student") && (role.equals("STUDENT_ROLE") || role.equals("TEACHER_ROLE"))){
            return true;
        }

        return uri.startsWith("/api/teacher") && role.equals("TEACHER_ROLE");

    }
}

