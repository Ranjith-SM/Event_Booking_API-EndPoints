package com.restapi.dto;

import com.restapi.model.AppUser;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AdminDto {

    public List<AppUser> getUsers(List<AppUser> users) {
        List<AppUser> userList = new ArrayList<>();

        for(AppUser user: users) {
            AppUser appUser = new AppUser();
            appUser.setId(user.getId());
            appUser.setName(user.getName());
            appUser.setUsername(user.getUsername());
            appUser.setCreatedAt(user.getCreatedAt());

            userList.add(appUser);

        }
        return userList;
    }
}
