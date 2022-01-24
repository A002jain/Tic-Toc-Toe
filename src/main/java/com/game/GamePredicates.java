package com.game;

import java.util.function.IntPredicate;
import java.util.function.Predicate;

public interface GamePredicates {

    Predicate<String> restart = i -> i.equalsIgnoreCase("r");

    Predicate<String> exit = s -> s.equalsIgnoreCase("e");

    IntPredicate validRange = i -> i > 0 && i < 10 ;
}
