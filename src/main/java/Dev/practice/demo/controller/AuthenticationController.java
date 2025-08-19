package Dev.practice.demo.controller;


import Dev.practice.demo.dto.Request.AuthenticationRequest;
import Dev.practice.demo.dto.response.AuthenticationResponse;
import Dev.practice.demo.service.AuthenticationService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import Dev.practice.demo.dto.response.ApiResponse;
import org.springframework.web.client.RestClient;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/login")
    ApiResponse<AuthenticationResponse> login(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        boolean result = authenticationService.authenticate(authenticationRequest);

        return ApiResponse.<AuthenticationResponse>builder()
                .result(AuthenticationResponse.builder()
                        .authenticated(result)
                        .build())
                .build();


    }
}
