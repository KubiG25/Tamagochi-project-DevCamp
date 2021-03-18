package com.maimai.tamagotchi.tamagotchi.impl;

import com.maimai.tamagotchi.ProgramCore;
import com.maimai.tamagotchi.event.tamagotchi.TamagotchiStatsChangeEvent;
import com.maimai.tamagotchi.item.Item;
import com.maimai.tamagotchi.tamagotchi.AbstractTamagotchi;
import com.maimai.tamagotchi.tamagotchi.TamagotchiType;
import com.maimai.tamagotchi.tamagotchi.action.TamagotchiAction;


public class CatTamagotchi extends AbstractTamagotchi{
    private final ProgramCore core;
    public CatTamagotchi(ProgramCore core, String name) {
        super(name, TamagotchiType.CAT);
        this.core = core;
    }

    @Override
    public void registerActions() {
        registerAction("Play", new TamagotchiAction.Builder()
                .createExecutor((player, item)-> {
                    core.getEventRegister().callEvent(new TamagotchiStatsChangeEvent(player.getTamagotchi()));
                    player.getTamagotchi().getHappiness().increase(40D);
                    player.getTamagotchi().getHunger().decrement(30D);
                    player.getTamagotchi().getThirst().decrement(30D);
                    player.getTamagotchi().getDirty().increase(30D);
                }).build());

        registerAction("Pet", new TamagotchiAction.Builder()
                .createExecutor(player -> {
                    core.getEventRegister().callEvent(new TamagotchiStatsChangeEvent(player.getTamagotchi()));
                    player.getTamagotchi().getHappiness().increase(20D);
                    player.getMoney().increase(5);
                    System.out.println(player.getTamagotchi().getName()+" is purring");
                }).build());

        registerAction("Bath", new TamagotchiAction.Builder()
                .createExecutor(player -> {
                    core.getEventRegister().callEvent(new TamagotchiStatsChangeEvent(player.getTamagotchi()));
                    player.getTamagotchi().getHappiness().decrement(20D);
                    player.getTamagotchi().getDirty().decrement(80D);
                    player.getMoney().increase(10);
                    System.out.println(player.getTamagotchi().getName()+" is very angry");
                }).build());

        registerAction("Exercise", new TamagotchiAction.Builder()
                .createExecutor(player -> {
                    core.getEventRegister().callEvent(new TamagotchiStatsChangeEvent(player.getTamagotchi()));
                    player.getTamagotchi().getHunger().decrement(40D);
                    player.getTamagotchi().getThirst().decrement(40D);
                    player.getTamagotchi().getHappiness().decrement(10D);
                    player.getTamagotchi().getDirty().increase(50D);
                    player.getMoney().increase(20);
                    System.out.println(player.getTamagotchi().getName()+" is irritated");
                }).build());

    }
}
