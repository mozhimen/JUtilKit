package com.mozhimen.java.utilk.javax.net;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

import javax.net.ssl.SSLSocketFactory;

/**
 * @ClassName UtilKSSLFactory
 * @Description TODO
 * @Author Mozhimen
 * @Date 2023/11/9 16:40
 * @Version 1.0
 */
public class UtilKSSLSocketFactory {
    public static SSLSocketFactory get_ofSSL() throws NoSuchAlgorithmException, KeyManagementException {
        return UtilKSSLContext.getSocketFactory_ofSSL();
    }

    public static SSLSocketFactory get_ofTLS() throws NoSuchAlgorithmException, KeyManagementException {
        return UtilKSSLContext.getSocketFactory_ofTLS();
    }
}