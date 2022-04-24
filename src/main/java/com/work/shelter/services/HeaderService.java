package com.work.shelter.services;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class HeaderService {

    /**
     * This method returns model attribute - additional menu item if admin is authorized.
     * If not admin, then this menu item will not appear.
     *
     * @return      the image at the specified URL
     */
    public String isUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth.getName().equals("admin")) {
            return "Добавить питомца";
        }
        return "unauth";
    }
}
