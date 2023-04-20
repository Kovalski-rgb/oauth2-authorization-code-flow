package br.pucpr.oauthserver.rest.requests.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data @AllArgsConstructor @NoArgsConstructor
public class ApiResponse {

    private String token_type;
    private int expires_in;
    private String access_token;
    private String scope;
    
}
