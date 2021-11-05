package com.chandalalatinashe.user.value.objects;

import com.chandalalatinashe.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class ResponseTemplateVO {
    private User user;
    private Department department;
}
