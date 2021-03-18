package com.maimai.tamagotchi.tamagotchi;

import com.maimai.tamagotchi.ProgramCore;
import com.maimai.tamagotchi.action.Action;
import com.maimai.tamagotchi.action.SimpleAction;
import com.maimai.tamagotchi.event.tamagotchi.TamagotchiStatsChangeEvent;
import com.maimai.tamagotchi.manager.Manager;
import com.maimai.tamagotchi.manager.ManagerImpl;
import com.maimai.tamagotchi.statistic.Statistic;
import com.maimai.tamagotchi.statistic.impl.DoubleStatistic;

import java.beans.ConstructorProperties;
import java.util.UUID;

public abstract class AbstractTamagotchi implements Tamagotchi {
    
    private final String id;
    private final String name;
    private final TamagotchiType type;
    private boolean alive;

    private final Statistic<Double> hunger;
    private final Statistic<Double> health;
    private final Statistic<Double> thirst;
    private final Statistic<Double> dirty;
    private final Statistic<Double> happiness;

    private final Manager<String, Action> actionManager;
    private final Statistic<Double> fatigue;

    @ConstructorProperties({
            "name",
            "type"
    })
    public AbstractTamagotchi(ProgramCore core,
                              String name,
                              TamagotchiType type) {

        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.type = type;
        this.alive = true;

        this.hunger = new DoubleStatistic();
        this.health = new DoubleStatistic();
        this.thirst = new DoubleStatistic();
        this.dirty = new DoubleStatistic();
        this.happiness = new DoubleStatistic();
        this.fatigue = new DoubleStatistic();

        this.actionManager = new ManagerImpl<>();

        registerActions();
        registerDefaultActions(core);
    }

    public abstract void registerActions();

    protected void registerAction(String name, Action action) {
        getActionManager().insert(name, action);
    }

    private void registerDefaultActions(ProgramCore core) {
        registerAction("Play", new SimpleAction.Builder()
                .createExecutor((player, item)-> {
                    core.getEventRegister().callEvent(new TamagotchiStatsChangeEvent(player.getTamagotchi()));
                    player.getTamagotchi().getHunger().decrement(30D);
                    player.getTamagotchi().getThirst().decrement(30D);
                    player.getTamagotchi().getDirty().increase(30D);
                    player.getMoney().increase(10);
                    switch (player.getTamagotchi().getType()){
                        case CAT:
                            System.out.println("Miauuu");
                            break;
                        case DOG:
                            System.out.println("Guauu guauuu");
                            break;
                        case PARROT:
                            System.out.println("Aagrrrr Aaggrrrrr");
                            break;
                        case HAMSTER:
                            System.out.println("Squeaky squeeaky");
                            break;
                        case RABBIT:
                            System.out.println("Sniff snifff");
                            break;
                    }
                }).build());

        registerAction("Sleep", new SimpleAction.Builder()
                .createExecutor((player, item) -> {
                    core.getEventRegister().callEvent(new TamagotchiStatsChangeEvent(player.getTamagotchi()));
                    player.getTamagotchi().getHunger().decrement(40D);
                    player.getTamagotchi().getThirst().decrement(40D);
                    player.getTamagotchi().getHappiness().increase(20D);
                    player.getTamagotchi().getDirty().increase(20D);
                    player.getTamagotchi().getFatigue().decrement(80D);
                    player.getMoney().increase(5);
                    switch (player.getTamagotchi().getType()){
                        case CAT:
                            System.out.println(player.getTamagotchi().getName()+" is tired, as always");
                            break;
                        case DOG:
                            System.out.println(player.getTamagotchi().getName()+" is running around the place");
                            break;
                        case PARROT:
                            System.out.println(player.getTamagotchi().getName()+" is screaming for food");
                            break;
                        case HAMSTER:
                            System.out.println(player.getTamagotchi().getName()+" wants to eat and go to bed again");
                            break;
                        case RABBIT:
                            System.out.println(player.getTamagotchi().getName()+" went to bed again");
                            break;
                    }
                }).build());



    }


    @Override
    public boolean isAlive() {
        return alive;
    }

    @Override
    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    @Override
    public TamagotchiType getType() {
        return type;
    }

    @Override
    public Manager<String, Action> getActionManager() {
        return actionManager;
    }

    @Override
    public Statistic<Double> getHunger() {
        return hunger;
    }

    @Override
    public Statistic<Double> getHealth() {
        return health;
    }

    @Override
    public Statistic<Double> getThirst() {
        return thirst;
    }

    @Override
    public Statistic<Double> getDirty() {
        return dirty;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getId() {
        return id;
    }
    @Override
    public Statistic<Double> getHappiness() {
        return happiness;
    }

    @Override
    public Statistic<Double> getFatigue() {
        return fatigue;
    }

    @Override
    public boolean isFatigue() {
        return fatigue.getValue() >= 90;
    }
}
