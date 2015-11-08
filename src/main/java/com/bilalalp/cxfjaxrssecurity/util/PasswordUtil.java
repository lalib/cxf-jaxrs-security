package com.bilalalp.cxfjaxrssecurity.util;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;


public final class PasswordUtil {

    private PasswordUtil() {
        // Util Class
    }

    public static String md5(String password) {
        if (password == null) {
            return null;
        }

        final byte[] bytes = DigestUtils.md5(password);
        return Hex.encodeHexString(bytes);
    }
}