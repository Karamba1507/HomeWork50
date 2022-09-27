package com.example.microgram.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ILike {
    private String fromWhom;
    private String forWhat;
    private LocalDateTime time;

}
