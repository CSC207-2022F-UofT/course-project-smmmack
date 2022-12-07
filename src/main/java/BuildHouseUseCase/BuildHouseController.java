package BuildHouseUseCase;

import UseCaseUniversal.CommandPerformer;

public class BuildHouseController implements CommandPerformer {

    BuildHouseInputBoundary buildHouseInputBoundary;

    public BuildHouseController(BuildHouseInputBoundary buildHouseInputBoundary){
        this.buildHouseInputBoundary = buildHouseInputBoundary;
    }

    // The string command input that the player types when it is the current player's turn.
    // The command declares the command to build house(s), the property that the player selects to
    // build house(s) on, and the number of house(s) that the player wants to build on the selected
    // property. If any command other than these received, throws error.

    public void performAction(String command) throws Exception{
        String[] buildHouseArguments;
        buildHouseArguments = command.split("\\s+");
        String property = buildHouseArguments[1];
        int numberOfHouse = Integer.parseInt(buildHouseArguments[2]);
        BuildHouseInputData buildHouseInputData = new BuildHouseInputData(property, numberOfHouse);
        buildHouseInputBoundary.performAction(buildHouseInputData);
    }

    public void performCommand(String command){
        try {
            performAction(command);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // Getter & Setters:

    public BuildHouseInputBoundary getBuildHouseInputBoundary() {
        return buildHouseInputBoundary;
    }

    public void setBuildHouseInputBoundary(BuildHouseInputBoundary buildHouseInputBoundary) {
        this.buildHouseInputBoundary = buildHouseInputBoundary;
    }
}
