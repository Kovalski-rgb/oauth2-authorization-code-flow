package br.pucpr.oauthserver.rest.requests;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ConfigurationProperties("oauth")
@PropertySource("/oauth.properties")
@AllArgsConstructor @Data @NoArgsConstructor
public class RequestsConfig {

    private String redirect_url;
    private String client_id;
    private String secret;

}
