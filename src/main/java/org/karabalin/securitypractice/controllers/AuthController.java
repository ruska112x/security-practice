package org.karabalin.securitypractice.controllers;

import jakarta.validation.Valid;
import org.karabalin.securitypractice.models.requests.SignIn;
import org.karabalin.securitypractice.models.requests.SignUp;
import org.karabalin.securitypractice.models.responses.JwtAuthenticationResponse;
import org.karabalin.securitypractice.services.AuthenticationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthenticationService authenticationService;

    public AuthController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/sign-up")
    public JwtAuthenticationResponse signUp(@RequestBody @Valid SignUp request) {
        return authenticationService.signUp(request);
    }

    @PostMapping("/sign-in")
    public JwtAuthenticationResponse signIn(@RequestBody @Valid SignIn request) {
        return authenticationService.signIn(request);
    }
}
