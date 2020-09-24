package com.company.enums;

import lombok.Getter;

@Getter
public enum HomePageHeaderLinks {

    ONLINE_BANKING_HEADER_LINK("Online Banking");

    private String headerLink;

    HomePageHeaderLinks(String headerLink) {
        this.headerLink = headerLink;
    }
}
