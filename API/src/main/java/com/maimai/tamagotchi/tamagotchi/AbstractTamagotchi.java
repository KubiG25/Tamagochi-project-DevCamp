package com.maimai.tamagotchi.tamagotchi;

import com.maimai.tamagotchi.action.Action;
import com.maimai.tamagotchi.action.tamagotchi.TamagotchiAction;
import com.maimai.tamagotchi.manager.Manager;
import com.maimai.tamagotchi.statistic.impl.DoubleStatistic;
import org.bson.types.ObjectId;

import java.util.List;

public abstract class AbstractTamagotchi implements Tamagotchi {

    public AbstractTamagotchi() {
        registerActions();

    }

    public abstract void registerActions();

    protected void registerAction(String name, Action<Tamagotchi> action) {
        getActionManager().insert(name, action);
    }

    @Override
    public boolean isAlive() {
        return false;
    }

    @Override
    public void setAlive(boolean alive) {

    }

    @Override
    public TamagotchiType getType() {
        return null;
    }

    @Override
    public Manager<Action<Tamagotchi>> getActionManager() {
        return null;
    }

    @Override
    public void setActionManager(Manager<Action<Tamagotchi>> actionManager) {

    }

    @Override
    public void setType(TamagotchiType type) {

    }

    @Override
    public List<Action<Tamagotchi>> getActions() {
        return null;
    }

    @Override
    public void setActions(List<TamagotchiAction> actions) {

    }

    @Override
    public DoubleStatistic getHunger() {
        return null;
    }

    @Override
    public void setHunger(DoubleStatistic hunger) {

    }

    @Override
    public DoubleStatistic getHealth() {
        return null;
    }

    @Override
    public void setHealth(DoubleStatistic health) {

    }

    @Override
    public DoubleStatistic getThirst() {
        return null;
    }

    @Override
    public void setThirst(DoubleStatistic thirst) {

    }

    @Override
    public DoubleStatistic getDirty() {
        return null;
    }

    @Override
    public void setDirty(DoubleStatistic dirty) {

    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void setName(String name) {

    }

    @Override
    public ObjectId getId() {
        return null;
    }

    @Override
    public void setId(ObjectId id) {

    }
}