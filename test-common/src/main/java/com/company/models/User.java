package com.company.models;

import lombok.*;

@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class User {

    private final String email;
    private final String password;

}
