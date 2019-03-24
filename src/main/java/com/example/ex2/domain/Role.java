package com.example.ex2.domain;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ADMIN, MOD1, MOD2, USER;
    @Override
    public String getAuthority() {
        return name();
    }

//ADMIN Админ
//MOD1 Редактор
//MOD2 Редактор экспертов
//USER Пользователь

}
