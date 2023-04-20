package br.pucpr.oauthserver.rest.requests.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class ProfileResponse {

    private UserData data;

}
@Data @AllArgsConstructor @NoArgsConstructor
class UserData{
    private String id;
    private String name;
    private String username;
}
