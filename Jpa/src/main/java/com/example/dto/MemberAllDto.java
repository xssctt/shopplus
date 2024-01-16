package com.example.dto;



import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberAllDto {
    private String avatar;
    private String birthday;
    private CardDto cardDto;
    private Integer id	;
    private String memberBalance;
    private String memberPayCount;
    private String memberPerPay	;
    private String memberRecharge;
    private String  memberTotalPay	;
    private String mobile;
    private String  name;
    private Integer point;
    private Integer sex	;
    private Integer status	;
    private Integer tenantId;
    private String tenantName;
}
