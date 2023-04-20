package br.pucpr.oauthserver.rest.requests;

import br.pucpr.oauthserver.rest.requests.response.ApiResponse;
import br.pucpr.oauthserver.rest.requests.response.ProfileResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

import java.util.HashMap;
import java.util.concurrent.CompletableFuture;

@Service // ou @Component
public class AuthServerClient {

    private final RequestsConfig requestConfig;
    private static final Logger logger = LogManager.getLogger();

    public AuthServerClient(RequestsConfig requestConfig) {
        this.requestConfig = requestConfig;
    }

    @Async CompletableFuture<ProfileResponse> getUserProfile(String accessToken){
        var api = new RestTemplate();
        var uri = new DefaultUriBuilderFactory()
                .builder()
                .scheme("https")
                .host("api.twitter.com")
                .path("/2/users/me")
                .build();

        var headers = new HttpHeaders();
        headers.add(HttpHeaders.AUTHORIZATION, "Bearer "+accessToken);

        var request = new HttpEntity<>(headers);

        System.out.println(request.getBody());

        var response = api.exchange(
            uri,
            HttpMethod.GET,
            request,
            ProfileResponse.class
        );

        if(response.getStatusCode().is2xxSuccessful()){
            var body = response.getBody();
            logger.info("Response: '"+ body+"'");
            return CompletableFuture.completedFuture(body);
        }
        return CompletableFuture.failedFuture(
                new Exception("Invalid response: %d" + response.getStatusCode().value())
        );
    }

    @Async
    public CompletableFuture<ApiResponse> exchangeAuthCode(String code, String codeChallenge){
        var api = new RestTemplate();
        var uri = new DefaultUriBuilderFactory()
                .builder()
                .scheme("https")
                .host("api.twitter.com")
                .path("/2/oauth2/token")
                .build();

        var headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, "application/x-www-form-urlencoded");

        MultiValueMap<String, String> map= new LinkedMultiValueMap<>();
        map.add("code", code);
        map.add("grant_type", "authorization_code");
        map.add("client_id", requestConfig.getClient_id());
        map.add("redirect_uri", requestConfig.getRedirect_url());
        map.add("code_verifier", codeChallenge);


        var request = new HttpEntity<>(map, headers);

        System.out.println(request.getBody());

        var response = api.postForEntity(
                uri,
                request,
                ApiResponse.class
        );

        if(response.getStatusCode().is2xxSuccessful()){
            var body = response.getBody();
            logger.info("Response: '"+ body+"'");
            return CompletableFuture.completedFuture(body);
        }
        return CompletableFuture.failedFuture(
                new Exception("Invalid response: %d" + response.getStatusCode().value())
        );
    }

}
