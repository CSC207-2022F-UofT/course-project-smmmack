package BuildHouseUseCase;

import UseCaseUniversal.CommandPerformer;

public class BuildHouseController implements CommandPerformer {

    BuildHouseInputBoundary buildHouseInputBoundary;

    public BuildHouseController(BuildHouseInputBoundary buildHouseInputBoundary){
        this.buildHouseInputBoundary = buildHouseInputBoundary;
    }

    public BuildHouseController(){

    }

    /**
     *
     * @param command The string command input, indicating the build house command followed buy the
     *                string abbreviation of the selected property, finally followed by the number of
     *                house(s) that the player wants to build.
     * @throws Exception Throws exception otherwise, in case the command is
     *                   not entered according to the format.
     */

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
