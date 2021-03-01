package com.github.jayreturns.jbbedwars.util;

import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
public class UnitPair<A> {

    public A first;
    public A second;

    public boolean contains(Object o) {
        return first == o|| second == o;
    }

}
