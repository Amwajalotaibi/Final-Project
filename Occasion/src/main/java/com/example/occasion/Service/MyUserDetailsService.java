package com.example.occasion.Service;

import com.example.occasion.Model.MyUser;
import com.example.occasion.Repostiroy.AuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService {
    private final AuthRepository authRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MyUser myUser=authRepository.findMyUserByUsername(username); //الفايند ما يتغير بس اللي بين الاقواس نحط فيه الايميل

        if(username==null){ // لو هو مو موجود نرمني لها ثرو
            throw new UsernameNotFoundException("Wrong username or password");
        }
        return myUser; // اذا موجوده ترجعه لي
    }

}
