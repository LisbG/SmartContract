package com.lisboa.smartcontract.model.entities;

import java.util.UUID;

public class RandomIdGenerator {

    public static String randomId(){
        return UUID.randomUUID().toString().substring(0, 4);
    }
}
