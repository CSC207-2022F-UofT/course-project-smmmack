package ViewModel;

import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * InputMapDictionary is basically a map the input maps. It's part of the view model. The input Field depend on this
 * class, but it does not need to update the input field when it's changed.
 */
public class InputMapDictionary {
    public static final String NO_MAP = null;
    private String currentMapName;
    private final Map<String, InputMap> maps;
    private String initialMapName;

    public InputMapDictionary() {
        this.currentMapName = NO_MAP;
        this.maps = new HashMap<>();
    }

    /**
     * Construct a new InputMapDictionary with the list of input maps. The keys are the names of the maps and the
     * initial map is the first map in the list
     * @param maps the list of maps to be put into the InputMapDictionary
     */
    public InputMapDictionary(List<InputMap> maps) {
        this.maps = new HashMap<>();
        setMaps(maps);
    }

    //getters

    public Map<String, InputMap> getMaps() {
        return new HashMap<>(maps);
    }

    public String getCurrentMapName() {
        return currentMapName;
    }

    public String getInitialMapName() {
        return initialMapName;
    }

    //setters

    /**
     * Set the map of input maps to contain everything in the argument list. <br>
     * Also updates initial map name: change it to the name of the first element in the list of maps. If the list is
     * empty, set it to NO_MAP (null). <br>
     * Also update current map name: change it to the new initial map name.
     * @param maps the list of maps that the
     */
    public void setMaps(List<InputMap> maps) {
        if (maps.isEmpty()) {
            initialMapName = NO_MAP;
        } else {
            initialMapName = maps.get(0).getName();
        }
        this.maps.clear();
        this.currentMapName = initialMapName;
        for (InputMap map: maps) {
            this.maps.put(map.getName(), map);
        }
    }

    public void setCurrentMapName(String currentMapName) {
        this.currentMapName = currentMapName;
    }

    public void setInitialMapName(String initialMapName) {
        this.initialMapName = initialMapName;
    }

    //other getters

    public InputMap getCurrentMap() throws InvalidParameterException {
        if (Objects.equals(currentMapName, NO_MAP)) {
            throw new InvalidParameterException("The input map dictionary has no current map.");
        }
        return maps.get(currentMapName);
    }

    public void callOnCurrentMap(String command) {
        InputMap map = getCurrentMap();
        map.call(command);
    }
}
