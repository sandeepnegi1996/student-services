package com.hashcodehub.springboot.studentservices.Model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MasterGroupEntityModel {

    private int id;
    private String name;
}
