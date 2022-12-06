package BuildHouseUseCase;

public class BuildHouseInputData {

    String buildHouseArgument;

    /**
     *
     * @param buildHouseArgument The argument indicating that the player wants to build
     *                           buildings on which property and how many buildings that
     *                           the player wants to build.
     */

    public BuildHouseInputData(String buildHouseArgument){

        this.buildHouseArgument = buildHouseArgument;
    }

    public String isBuildHouseArgument(){
        return buildHouseArgument;
    }

    public void setBuildHouseArgument(String buildHouseArgument){
        this.buildHouseArgument = buildHouseArgument;
    }
}
