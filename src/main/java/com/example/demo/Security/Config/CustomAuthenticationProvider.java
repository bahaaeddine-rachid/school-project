package com.example.demo.Security.Config;

import com.example.demo.Security.ConfigUserDTO.UserDetailsImpl;
import com.example.demo.Security.ConfigModels.User;
import com.example.demo.repository.UserRepository;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider extends DaoAuthenticationProvider {
    @Autowired
    UserRepository userRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder= new BCryptPasswordEncoder();


    @SneakyThrows
    @Override
    public Authentication authenticate(Authentication auth){

        final User user = userRepository.findByUsername(auth.getName()).orElseThrow(()-> {
            return new Exception("user not found");
        });

        UserDetailsImpl userDetails=new UserDetailsImpl(user);

        if(userDetails.getPassword().length()>0){
            if (!bCryptPasswordEncoder.matches((CharSequence) auth.getCredentials(),userDetails.getPassword())){
                throw  new Exception("invalid password");
            }
        }else {
            throw  new Exception("password cannot be empty ");
        }

        WebAuthenticationDetails details= (WebAuthenticationDetails) auth.getDetails();
        return new UsernamePasswordAuthenticationToken(
                userDetails,
                userDetails.getPassword(),
                userDetails.getAuthorities()
        );

    }

    @Override
    protected void doAfterPropertiesSet(){
        if(super.getUserDetailsService() != null){
            System.out.println("UserDetailsService has been configured properly");
        }
    }
}
