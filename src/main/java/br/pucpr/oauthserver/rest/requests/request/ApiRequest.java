package br.pucpr.oauthserver.rest.requests.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiRequest {
    private String code;
    private String grant_type;
    private String client_id;
    private String redirect_uri;
    private String code_verifier;
}
