package com.example.demo.Security.Config;

import com.example.demo.Security.ConfigUserDTO.JwtConfig;
import com.example.demo.Security.ConfigUserDTO.UserDetailsImpl;
import com.example.demo.Security.ConfigService.UserService;
import com.example.demo.Security.ConfigModels.User;
import com.example.demo.repository.UserRepository;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

public class AuthTokenFilter extends OncePerRequestFilter implements Filter {

    private  final JwtConfig jwtConfig;
    private JwtTokenManager jwtTokenManager;

  UserService userService;
  @Autowired
    UserRepository userRepository;
  @Autowired
    private HandlerExceptionResolver handlerExceptionResolver;

    public AuthTokenFilter(JwtConfig jwtConfig, JwtTokenManager jwtTokenManager, UserService userService, HandlerExceptionResolver handlerExceptionResolver) {
        this.jwtConfig = jwtConfig;
        this.jwtTokenManager = jwtTokenManager;
        this.userService = userService;
        this.handlerExceptionResolver = handlerExceptionResolver;
    }


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String header = request.getHeader(jwtConfig.getHeader());

        if (header == null || !header.startsWith(jwtConfig.getPrefix())){
            filterChain.doFilter(request,response);
            return;
        }
        String token= header.replace(jwtConfig.getPrefix(),"");
        Claims claims = jwtTokenManager.getClaimsFromJwt(token);
        String username= claims.getSubject();
        Optional<User> tmp = userService.finduserbyusername(username);

        if (jwtTokenManager.validatetoken(token)){
            UsernamePasswordAuthenticationToken auth= tmp
                    .map(UserDetailsImpl::new)
                    .map(userDetails -> {
                        UsernamePasswordAuthenticationToken authenticationToken=
                                new UsernamePasswordAuthenticationToken(
                                        userDetails, null,userDetails.getAuthorities()
                                );
                        authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                        return  authenticationToken;
                    }).orElse(null);
            SecurityContextHolder.getContext().setAuthentication(auth);
        }else{
            SecurityContextHolder.clearContext();
        }
        filterChain.doFilter(request,response);

    }
}
