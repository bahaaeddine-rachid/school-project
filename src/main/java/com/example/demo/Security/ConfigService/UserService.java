package com.example.demo.Security.ConfigService;

import com.example.demo.Security.Config.CustomAuthenticationProvider;
import com.example.demo.Security.Config.JwtTokenManager;
import com.example.demo.Security.ConfigUserDTO.LoginResponse;
import com.example.demo.Security.ConfigUserDTO.UserDTO;
import com.example.demo.Security.ConfigUserDTO.UserDetailsImpl;
import com.example.demo.Security.ConfigModels.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final PasswordEncoder passwordEncoder= new BCryptPasswordEncoder();
    @Autowired
    UserRepository userRepository;

    @Autowired
    JwtTokenManager jwtTokenManager;
    @Autowired
    CustomAuthenticationProvider authenticationProvider;
    public User createUser(UserDTO save){

        save.setPassword(passwordEncoder.encode(save.getPassword()));

        return userRepository.save(new User(save));
    }

    public Optional<User> finduserbyusername(String username){


        return userRepository.findByUsername(username);
    }


    public User login(UserDTO u) {
        Authentication authentication= authenticationProvider.authenticate(
                new UsernamePasswordAuthenticationToken(u.getUsername(),u.getPassword()));
                User user=userRepository.findByUsername(u.getUsername()).get();
                return user;

    }

    public LoginResponse generateToken(User user ) throws Exception {
        UserDetailsImpl tmp= Optional.of(user)
                .map(UserDetailsImpl::new)
                .get();
        return
                Optional.of(tmp)
                        .map(userDetails -> new UsernamePasswordAuthenticationToken(
                                userDetails, null,userDetails.getAuthorities()
                        ))
                .map(jwtTokenManager::generateToken).map(LoginResponse::new).orElseThrow(()->new Exception("unable to generate access token"));
    }
}
