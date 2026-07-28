package com.risk.manager.infra.security7;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Component
public class ApiKeyAuthenticationFilter extends OncePerRequestFilter {

    @Value("${spring.api.key}")
    String key;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

       String authentication = request.getHeader("X-API-Key");

       if(authentication == null){
           response.setStatus(401);
           return;
       }

       byte[] hash;
       byte[] keyDigest;

        try {
            MessageDigest mD = MessageDigest.getInstance("SHA-256");
            hash = mD.digest(authentication.getBytes());
            keyDigest = mD.digest(key.getBytes());
        }catch (NoSuchAlgorithmException e){
            response.setStatus(500);
            return;
        }

        if(MessageDigest.isEqual(hash, keyDigest)){
            UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
                    "risk-engine",
                    null,
                    List.of(new SimpleGrantedAuthority("SYSTEM_ROLE"))
            );
            SecurityContextHolder.getContext().setAuthentication(auth);
            filterChain.doFilter(request, response);
        }else{
            response.setStatus(401);
        }




    }
}
