package com.utnphones.UTNPhonesDiazFtMurrie.session;

import com.utnphones.UTNPhonesDiazFtMurrie.model.domain.User;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@AllArgsConstructor
@NoArgsConstructor
public class SessionManager
{
    //region Properties:
    Map<String, Session> sessionMap = new Hashtable<>();

    int sesionExpiration = 60;
    //endregion

    //region Methods:
    public String createSession(User user) {
        String token = UUID.randomUUID().toString();
        sessionMap.put(token, new Session(token, user, new Date(System.currentTimeMillis())));
        return token;
    }

    public String createSession(User user, String token) {
        sessionMap.put(token, new Session(token, user, new Date(System.currentTimeMillis())));
        return token;
    }

    public Session getSession(String token) {
        Session session = sessionMap.get(token);
        if (session!=null) {
            session.setLastAction(new Date(System.currentTimeMillis()));
        }
        return session;
    }

    public void removeSession(String token) {
        sessionMap.remove(token);
    }

    public void expireSessions() {
        for (String s : sessionMap.keySet()) {
            Session session = sessionMap.get(s);
            if (session.getLastAction().getTime() < System.currentTimeMillis() + (sesionExpiration*1000)) {
                System.out.println("Expiring session " + s);
                sessionMap.remove(s);
            }
        }
    }

    public User getCurrentUser(String token) {
        return getSession(token).getLoggedUser();
    }
    //endregion
}
