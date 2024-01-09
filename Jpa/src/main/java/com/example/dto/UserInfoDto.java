package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserInfoDto {

    private String   tenantAddress;
    private String   tenantCreatedAt;
    private Integer   tenantId	;
    private String   tenantName;
    private String  tenantPhone	;
    private Integer   tenantStatus;
    private String  tenantUpdatedAt;
    private String  userAvatar	;
    private String  userCreatedAt	;
    private String  userEmail;
    private Integer  userId;
    private String   userMobile	;
    private String   userName;
    private Integer  userStatus	;
    private String   userUpdatedAt;

}
