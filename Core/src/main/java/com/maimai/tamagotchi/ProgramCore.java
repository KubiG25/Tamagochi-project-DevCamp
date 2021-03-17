package com.maimai.tamagotchi;

import com.maimai.tamagotchi.command.CommandRegister;
import com.maimai.tamagotchi.database.MongoDbManager;
import com.maimai.tamagotchi.event.EventRegister;
import com.maimai.tamagotchi.player.Player;

public interface ProgramCore {

    void initCore();

    boolean isEnabled();

    void setEnabled(boolean bol);

    EventRegister getEventRegister();

    CommandRegister getCommandRegister();

    Player getPlayer();

    void setPlayer(Player player);

    MongoDbManager getMongoManager();
}