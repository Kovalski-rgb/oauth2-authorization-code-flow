package br.pucpr.oauthserver.rest.requests;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/requests")
public class RequestResource {

    private RequestService service;

    public RequestResource(RequestService service) {
        this.service = service;
    }

    @PostMapping("/access-token")
    public ResponseEntity<String> getAccessToken(
            @Valid @NotNull String credentials
    ){
        return ResponseEntity.ok(service.login(credentials));
    }

    @GetMapping("/callback")
    public ResponseEntity<String> callback(){
        return ResponseEntity.ok("everything OK :]");
    }

}
