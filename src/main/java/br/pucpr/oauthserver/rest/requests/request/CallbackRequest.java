package br.pucpr.oauthserver.rest.requests.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CallbackRequest {

    private String state;
    private String code;

}
