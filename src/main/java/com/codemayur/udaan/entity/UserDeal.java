package com.codemayur.udaan.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Builder
// TODO @Entity
public class UserDeal {

    // TODO Composite key - user and deal ids
    private Long userId;
    private Long dealId;

}
