package com.maimai.tamagotchi.tamagotchi.impl;

import com.maimai.tamagotchi.tamagotchi.AbstractTamagotchi;
import com.maimai.tamagotchi.tamagotchi.TamagotchiType;

public class DogTamagotchi extends AbstractTamagotchi {
    public DogTamagotchi(String id, String name, TamagotchiType type) {
        super(id, name, type);
    }

    @Override
    public void registerActions() {

    }
}
