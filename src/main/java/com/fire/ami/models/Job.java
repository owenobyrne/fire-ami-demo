package com.fire.ami.models;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;


@Accessors(chain = true)
public class Job {
    @Getter @Setter private String name;

}
