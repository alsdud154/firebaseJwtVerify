package kr.co.velnova.firebase.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class CurrentUser {
    private String userId;
    private String email;
}
