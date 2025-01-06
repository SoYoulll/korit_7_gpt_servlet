package com.korit.servlet_study.server_flow;

public class Tomcat {

    public static void service(String url, String method) {
        Request req = new Request();
        Response resq = new Response();

        TestFilter.doFilter(req, resq);
    }
}
