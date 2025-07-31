package com.Akriti;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebFilter("/addInfo") // or "/*" for all requests
public class filter implements Filter {
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        String s="";
        String t="";
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        int id = Integer.parseInt(req.getParameter("id"));
        String sname = req.getParameter("sname");
        if(id>1) {
//            chain.doFilter(request, response);
            s="true";
        }
        int j=sname.length();
        if(j>4)
        {
//            chain.doFilter(request, response);
            t="true";

        }
        if(s.equals("true") && t.equals("true"))
        {
            chain.doFilter(request, response);
        }
        else
        {
            PrintWriter out = response.getWriter();
            out.println("error");
        }

    }
    public void init(FilterConfig fConfig) throws ServletException {

    }
}