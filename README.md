# oauth2-authorization-code-flow
Atividade de OAuth do Bradesco

## How to run?

 - First things first, clone the project:
 ```
 git clone https://github.com/Kovalski-rgb/oauth2-authorization-code-flow.git
 cd oauth2-authorization-code-flow
 ```

1 - Set the sensitive information about your API here
`src/main/resources/oauth.properties`
set the following lines with your user data
```
oauth.redirect_url=[url]
oauth.client_id=[client_id]
oauth.secret=[client_secret]
```

2 - If you are on linux, you can simply run the linux-starter.sh
```./linux-starter.sh```

2.1 - On windows, try running (THIS WAS NOT TESTED TO RUN ON WINDOWS):
```
mvn -f "pom.xml" spring-boot:run
```

3 - Your server should be up and running, you should be able to access swagger-ui with the following link:
- http://127.0.0.1:8080/oauthserver/api/
