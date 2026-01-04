package com.back.shared.member.out;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class MemberApiClient {
    private final RestClient restClient;

    public MemberApiClient(@Value("${custom.global.internalBackUrl}") String internalBackUrl) {
        this.restClient = RestClient.builder()
                .baseUrl(internalBackUrl + "/api/v1/member")
                .build();
    }

    public String getRandomSecureTip() {
        try {
            return restClient.get()
                    .uri("/members/randomSecureTip")
                    .retrieve()
                    .body(String.class);
        } catch (Exception e) {
            return "기본 보안 팁";
        }
    }
}