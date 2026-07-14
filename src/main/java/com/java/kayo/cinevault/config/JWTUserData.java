package com.java.kayo.cinevault.config;

import lombok.Builder;

@Builder
public record JWTUserData(Long id, String email, String name){
}
