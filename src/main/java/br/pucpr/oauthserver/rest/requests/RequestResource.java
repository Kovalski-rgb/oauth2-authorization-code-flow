package br.pucpr.oauthserver.rest.requests;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/requests")
public class RequestResource {

    private RequestService service;

    public RequestResource(RequestService service) {
        this.service = service;
    }

    @PostMapping("/access-token")
    public ResponseEntity<String> getAccessToken(
            @Valid @RequestParam String code,
            @Valid @RequestParam String challenge
    ){
        return ResponseEntity.ok(service.getAccessToken(code, challenge));
    }

    @GetMapping("/callback")
    public ResponseEntity<String> callback(){
        return ResponseEntity.ok("try using this as callback later");
    }

}
