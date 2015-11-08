
package com.bilalalp.cxfjaxrssecurity.service.user;

import com.bilalalp.cxfjaxrssecurity.security.SystemUser;
import com.bilalalp.cxfjaxrssecurity.security.SystemUserAuthToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class LoggedUserServiceImpl implements LoggedUserService {

    @Override
    public SystemUser getLoggerUser() {
        final SystemUserAuthToken systemUserAuthToken = getAuthentication(getSecurityContext());
        return systemUserAuthToken.getSystemUser();
    }

    protected SystemUserAuthToken getAuthentication(SecurityContext securityContext) {
        return (SystemUserAuthToken) securityContext.getAuthentication();
    }

    public SecurityContext getSecurityContext() {
        return SecurityContextHolder.getContext();
    }
}