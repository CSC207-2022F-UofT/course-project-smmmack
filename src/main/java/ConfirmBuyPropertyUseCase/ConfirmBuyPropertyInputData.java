package ConfirmBuyPropertyUseCase;

import MainEntities.Player;
import Properties.Property;

public class ConfirmBuyPropertyInputData {
    Player player;
    Property property;

    boolean decision;


    public ConfirmBuyPropertyInputData(Player player, Property property, boolean decision) {
        this.player = player;
        this.property = property;
        this.decision = decision;
    }

    public Player getPlayer() {
        return player;
    }

    public Property getProperty() {
        return property;
    }

    public boolean getDecision() {
        return decision;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setDecision(boolean decision){
        this.decision = decision;
    }

}
