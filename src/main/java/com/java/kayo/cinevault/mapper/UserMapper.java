package com.java.kayo.cinevault.mapper;

import com.java.kayo.cinevault.Entity.User;
import com.java.kayo.cinevault.request.UserRequest;
import com.java.kayo.cinevault.response.UserResponse;
import lombok.experimental.UtilityClass;
import org.springframework.web.bind.annotation.RequestBody;

@UtilityClass
public class UserMapper {

    public static User toUser(@RequestBody UserRequest request) {

        return User.builder()
                .name(request.name())
                .email(request.email())
                .password(request.password())
                .build();
    }

    public static UserResponse toUserResponse(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }


}
