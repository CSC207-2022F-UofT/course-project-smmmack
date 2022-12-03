package ViewModel;

import java.util.ArrayList;
import java.util.List;

    /**
     * The view model of a player, all information here should go to the players panel. Change in the command lines or
     * board should be specified otherwise.
     */
    public class PlayerViewModel {
        private String name;
        private int cash;
        private List<String> propertyAbbrs;
        /**
         * The number of turns the player need to stay in jail. Int implementation allows sentences longer than 1 turn.
         */
        private int jailTurn;
        //TODO: in order to use ownership indicators, we need the indicator picture files here as instance variables
        //TODO: in order to let player panel show different color for each player, a color instance variable is needed

        /**
         * Create a new PlayerVM object with these default parameters: <br>
         * cash = 0 <br>
         * propertiesAbbrs = new ArrayList<>()<br>
         * jailTurn = 0
         *
         * @param name the name of the player
         */
        public PlayerViewModel(String name) {
            this.name = name;
            this.cash = 0;
            this.propertyAbbrs = new ArrayList<>();
            this.jailTurn = 0;
        }

        //setters

        public void setName(String name) {
            this.name = name;
        }

        public void setCash(int cash) {
            this.cash = cash;
        }

        public void setJailTurn(int jailTurn) {
            this.jailTurn = jailTurn;
        }

        public void setPropertyAbbrs(List<String> propertyAbbrs) {
            this.propertyAbbrs = new ArrayList<>(propertyAbbrs);
        }

        //getters

        public String getName() {
            return name;
        }

        public int getCash() {
            return cash;
        }

        public List<String> getPropertyAbbrs() {
            return new ArrayList<>(propertyAbbrs);
        }

        public int getJailTurn() {
            return jailTurn;
        }
    }
