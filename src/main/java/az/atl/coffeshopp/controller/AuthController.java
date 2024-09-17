package az.atl.coffeshopp.controller;

import az.atl.coffeshopp.model.constant.TokenPair;
import az.atl.coffeshopp.request.AuthenticationRequest;
import az.atl.coffeshopp.request.RegisterRequest;
import az.atl.coffeshopp.response.AuthenticationResponse;
import az.atl.coffeshopp.response.RegisterResponse;
import az.atl.coffeshopp.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> register(@RequestBody RegisterRequest request){
        return ResponseEntity.ok(authenticationService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest request){
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }

    @Operation(summary = "Use refresh token to get new access token")
    @PostMapping("/refresh")
    public ResponseEntity<TokenPair> refreshToken(@AuthenticationPrincipal UserDetails userDetails){
        return ResponseEntity.ok(authenticationService.refreshToken(userDetails));
    }

}
