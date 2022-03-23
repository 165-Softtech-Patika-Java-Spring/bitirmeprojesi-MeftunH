package com.FinalProject.FinalProject.security.service;


import com.FinalProject.FinalProject.security.security.JwtTokenGenerator;
import com.FinalProject.FinalProject.security.security.JwtUserDetails;
import com.FinalProject.FinalProject.user.dto.UserDto;
import com.FinalProject.FinalProject.user.dto.UserSaveRequestDto;
import com.FinalProject.FinalProject.user.entity.User;
import com.FinalProject.FinalProject.user.service.UserService;
import com.FinalProject.FinalProject.user.service.entityService.UserEntityService;
import com.FinalProject.FinalProject.security.dto.SecLoginRequestDto;
import com.FinalProject.FinalProject.security.enums.EnumJwtConstant;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 * @author Bahadır Memiş
 * @since 1.0.0
 */
@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserService userService;
    private final UserEntityService userEntityService;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenGenerator jwtTokenGenerator;

    public UserDto register(UserSaveRequestDto userSaveRequestDto) {

        UserDto userDto = userService.save(userSaveRequestDto);

        return userDto;
    }

    public String login(SecLoginRequestDto secLoginRequestDto) {

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(secLoginRequestDto.getId().toString(), secLoginRequestDto.getPassword());
        Authentication authentication = authenticationManager.authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtTokenGenerator.generateJwtToken(authentication);

        String bearer = EnumJwtConstant.BEARER.getConstant();

        return bearer + token;
    }

    public User getCurrentCustomer() {

        JwtUserDetails jwtUserDetails = getCurrentJwtUserDetails();

        User user = null;
        if (jwtUserDetails != null){
            user = userEntityService.getByIdWithControl(jwtUserDetails.getId());
        }

        return user;
    }

    public Long getCurrentCustomerId(){

        JwtUserDetails jwtUserDetails = getCurrentJwtUserDetails();

        Long jwtUserDetailsId = null;
        if (jwtUserDetails != null){
            jwtUserDetailsId = jwtUserDetails.getId();
        }

        return jwtUserDetailsId;
    }

    private JwtUserDetails getCurrentJwtUserDetails() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        JwtUserDetails jwtUserDetails = null;
        if (authentication != null && authentication.getPrincipal() instanceof JwtUserDetails){
            jwtUserDetails = (JwtUserDetails) authentication.getPrincipal();
        }
        return jwtUserDetails;
    }
}
