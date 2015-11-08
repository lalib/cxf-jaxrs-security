package com.bilalalp.cxfjaxrssecurity.security;

import lombok.Getter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

@Getter
public class SystemUserAuthToken extends UsernamePasswordAuthenticationToken {

    private final String token;
    private final SystemUser systemUser;

    public SystemUserAuthToken(String token, SystemUser systemUser) {
        super(token, null, systemUser.getAuthorities());
        this.token = token;
        this.systemUser = systemUser;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof SystemUserAuthToken) || !super.equals(o)) {
            return false;
        }

        final SystemUserAuthToken that = (SystemUserAuthToken) o;

        if (token != null ? !token.equals(that.token) : that.token != null) {
            return false;
        }

        return !(systemUser != null ? !systemUser.equals(that.systemUser) : that.systemUser != null);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (token != null ? token.hashCode() : 0);
        result = 31 * result + (systemUser != null ? systemUser.hashCode() : 0);
        return result;
    }
}
