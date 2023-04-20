package br.pucpr.oauthserver.rest.requests;

import br.pucpr.oauthserver.rest.requests.response.ApiResponse;
import br.pucpr.oauthserver.rest.requests.response.ProfileResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
public class RequestService {
    private static final Logger logger = LogManager.getLogger();

    private final AuthServerClient authServer;

    public RequestService(AuthServerClient authServer) {
        this.authServer = authServer;
    }

    public ApiResponse getAccessToken(String code, String challenge){
        return authServer.exchangeAuthCode(code, challenge)
                .exceptionally(error-> {
                    logger.error("Login failed - ", error.getCause());
                    return null;
                }).join();
    }

    public ProfileResponse getUserData(String accessToken){
        return authServer.getUserProfile(accessToken)
                .exceptionally(error-> {
                    logger.error("Fetch failed - ", error.getCause());
                    return null;
                }).join();
    }

}
