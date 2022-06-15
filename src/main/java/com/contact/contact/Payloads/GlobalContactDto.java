package com.contact.contact.Payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GlobalContactDto {
    private int id;
    private String name;
    private String number; 
    private boolean spam; 
}
