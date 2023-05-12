package com.intec.project.entities;

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
public class firma {
    private int firma_id;
    private int DHL_id;
    private int DVS_id;
    private int GLS_id;
}
