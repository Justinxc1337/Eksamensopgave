package com.intec.project.entities;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class registering {
    private int registering_id;
    private int firma_id;
    private int lokation_id;
    private LocalDateTime indtjekningstidspunkt;
}
