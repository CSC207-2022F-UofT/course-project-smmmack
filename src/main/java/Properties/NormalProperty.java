package Properties;

import MainEntities.Player;

import java.security.InvalidParameterException;

/**
 * NormalProperty is a kind of property that players can build house on, and rent changes as the house changes. It may
 * also have several other properties that are in the same color group. <br>
 * When a player owns all properties in one color group, the rent is doubled if nothing is built on this property. Also,
 * the player may only build houses on the property if he owns all properties in the same group.
 */
public class NormalProperty extends Property {
    public static final int MAX_HOUSE_LEVEL = 5;
    public static final int MIN_HOUSE_LEVEL = 0;
    /**
     * houseLevel indicates how many houses or restaurants are been built on this property. <p>
     * 0   - no house built <p>
     * 1~4 - has 1~4 houses <p>
     * 5   - has a hotel
     */
    private int houseLevel;

    /**
     * rentList is a list of rents, with the corresponding houseLevels as their index
     */
    private int[] rentList;

    /**
     * sameColorGroupProperties contains all other properties in the same color group. Does not include this property
     * itself.
     */
    private NormalProperty[] sameColorGroupProperties;
    private int housePrice;
    private int hotelPrice;

    /**
     * Create a new NormalProperty object with these default parameters: <p>
     * houseLevel = 0 <p>
     * SameColorGroupProperties = new int[] <p>
     * owner = Player.OWNERLESS <p>
     * Mortgaged = false
     *
     * @param rentList a list of rents, with the corresponding houseLevels as their index. The length of rentList must
     *                 be MAX_HOUSE_LEVEL + 1
     *
     * @param name the name of the property
     *
     * @param abbreviation the abbreviation of the name of the property, would be used in command lines
     *
     * @param price the price of the property
     *
     * @param housePrice the price to build a house on this property
     *
     * @param hotelPrice the price to build a hotel on this property
     */
    public NormalProperty(int[] rentList, String name, String abbreviation, int price, int housePrice, int hotelPrice) throws InvalidParameterException {
        super(name, abbreviation, price);
        if (rentList.length != MAX_HOUSE_LEVEL + 1) {
            throw new InvalidParameterException("length of rentList must be " + (MAX_HOUSE_LEVEL + 1));
        }
        this.houseLevel = 0;
        this.rentList = rentList.clone();
        this.sameColorGroupProperties = new NormalProperty[]{this};
        this.housePrice = housePrice;
        this.hotelPrice = hotelPrice;
    }

    //setters
    public void setHouseLevel(int houseLevel) throws InvalidParameterException {
        if (MIN_HOUSE_LEVEL <= houseLevel && houseLevel <= MAX_HOUSE_LEVEL)
            this.houseLevel = houseLevel;
        else
            throw new InvalidParameterException(
                    "houseLevel can't exceed range [" + MIN_HOUSE_LEVEL + ", " + MAX_HOUSE_LEVEL + "]"
            );
    }

    public void setRentList(int[] rentList) {
        this.rentList = rentList.clone();
    }

    public void setSameColorGroupProperties(NormalProperty[] sameColorGroupProperties) {
        this.sameColorGroupProperties = sameColorGroupProperties.clone();
    }

    public void setHousePrice(int housePrice) {
        this.housePrice = housePrice;
    }

    public void setHotelPrice(int hotelPrice) {
        this.hotelPrice = hotelPrice;
    }

    //getters
    public int getHouseLevel() {
        return houseLevel;
    }

    public int[] getRentList() {
        return rentList.clone();
    }

    public NormalProperty[] getSameColorGroupProperties() {
        return sameColorGroupProperties.clone();
    }

    public int getHousePrice() {
        return housePrice;
    }

    public int getHotelPrice() {
        return hotelPrice;
    }

    //other getters
    @Override
    public int getRent(Player target) {
        return rentList[houseLevel];
    }

    //other setters

    /**
     * increases the houseLevel by 1.
     */
    public void houseUp() throws InvalidParameterException {
        setHouseLevel(houseLevel + 1);
    }

    /**
     * increases the houseLevel by 1.
     */
    public void houseDown() throws InvalidParameterException {
        setHouseLevel(houseLevel - 1);
    }
}
