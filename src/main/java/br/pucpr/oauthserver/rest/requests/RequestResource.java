package br.pucpr.oauthserver.rest.requests;

import br.pucpr.oauthserver.rest.requests.request.CallbackRequest;
import br.pucpr.oauthserver.rest.requests.response.ApiResponse;
import br.pucpr.oauthserver.rest.requests.response.ProfileResponse;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/requests")
public class RequestResource {

    private RequestService service;

    public RequestResource(RequestService service) {
        this.service = service;
    }

    @Operation(summary = "Troca o authentication-code para um access-token")
    @PostMapping("/access-token")
    public ResponseEntity<ApiResponse> getAccessToken(
            @Valid @RequestParam String code,
            @Valid @RequestParam String challenge
    ){
        var result = service.getAccessToken(code, challenge);
        if(result == null){
            ResponseEntity.status(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(result);
    }

    @Operation(summary = "Pega informações básicas do perfil do twitter do usuário autenticado")
    @PostMapping("/getUserProfile")
    public ResponseEntity<ProfileResponse> userProfile(
            @RequestParam String accessToken
    ){
        var result = service.getUserData(accessToken);
        return ResponseEntity.ok(result);
    }

    @Operation(summary = "Usado pro callback do 'frontend'")
    @GetMapping("/callback")
    public ResponseEntity<String> callback(
            @RequestParam String state,
            @RequestParam String code
    ){
        return ResponseEntity.ok("state: [" +state +"]" +"<br>code: [" +code +"]");
    }

}
