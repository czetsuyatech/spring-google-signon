package com.czetsuyatech.oauth.web.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
public class CalendarController {

  @GetMapping("/calendar-entries")
  public String entries() {

    log.debug("token={}", getSessionBearerToken());


    return "Hello";

  }
  private String getSessionBearerToken() {

    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    JwtAuthenticationToken oauthToken = (JwtAuthenticationToken) authentication;
    return oauthToken.getToken().getTokenValue();
//    OAuth2AuthorizedClient client =
//        authorizedClientService.loadAuthorizedClient(
//            oauthToken.getAuthorizedClientRegistrationId(),
//            oauthToken.getName());
//
//    return client.getAccessToken().getTokenValue();
  }
}
