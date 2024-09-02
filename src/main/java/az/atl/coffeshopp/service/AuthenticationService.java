package az.atl.coffeshopp.service;

import az.atl.coffeshopp.dao.entity.UserEntity;
import az.atl.coffeshopp.dao.repository.UserRepository;
import az.atl.coffeshopp.exception.NoSuchUserException;
import az.atl.coffeshopp.exception.UserAlreadyExistException;
import az.atl.coffeshopp.model.constant.TokenPair;
import az.atl.coffeshopp.model.enums.Role;
import az.atl.coffeshopp.model.enums.TokenType;
import az.atl.coffeshopp.request.AuthenticationRequest;
import az.atl.coffeshopp.request.RegisterRequest;
import az.atl.coffeshopp.response.AuthenticationResponse;
import az.atl.coffeshopp.response.RegisterResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;

@Slf4j
@RequiredArgsConstructor
public class AuthenticationService {
    private final JWTService jwtService;
    private final PasswordEncoder encoder;
    private final UserRepository repository;
    private final AuthenticationManager authManager;

    public RegisterResponse register(RegisterRequest request) {
        //Register the user to repository and generate a token

        var exist = repository.getUserEntityByPhoneNumber(request.getPhoneNumber()).isPresent();
        if (exist) {
            throw new UserAlreadyExistException("User already exist");
        }

//        if (request.getPassword().equals(request.getConfirmPassword())) {
            var user = UserEntity.builder()
                    .name(request.getName())
                    .surname(request.getSurname())
                    .password(encoder.encode(request.getPassword()))
                    .role(Role.USER)
                    //.createdDate(LocalDateTime.now())
                    .build();

        UserEntity save = repository.save(user);

        return RegisterResponse.buildRegisterDto(save);
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getPhoneNumber(),
                        request.getPassword()
                )
        );
        var user = repository.getUserEntityByPhoneNumber(request.getPhoneNumber())
                .orElseThrow(() -> new NoSuchUserException("User not found"));
        return AuthenticationResponse.builder()
                .userId(user.getId())
                .tokenPair(getTokenPair(user))
                .build();
    }


    public TokenPair refreshToken(UserDetails userDetails) {
        var user = repository.getUserEntityByPhoneNumber(userDetails.getUsername())
                .orElseThrow(() -> new NoSuchUserException("User not found with email " + userDetails.getUsername()));

        return getTokenPair(user);
    }

    private TokenPair getTokenPair(UserDetails user) {
        TokenPair tokenResponse = new TokenPair();
        tokenResponse.setAccessToken(jwtService.generateToken(user, TokenType.ACCESS));
        tokenResponse.setRefreshToken(jwtService.generateToken(user, TokenType.REFRESH));
        return tokenResponse;
    }
}
