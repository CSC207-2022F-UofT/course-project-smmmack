package BuildHouseUseCase;

public class BuildHouseController {

    BuildHouseInputBoundary buildHouseInputBoundary;
    final String buildHouseArgument;

    public BuildHouseController(BuildHouseInputBoundary buildHouseInputBoundary, String buildHouseArgument){
        this.buildHouseInputBoundary = buildHouseInputBoundary;
        this.buildHouseArgument = buildHouseArgument;
    }

    public void performAction() throws Exception{
        BuildHouseInputData buildHouseInputData = new BuildHouseInputData(buildHouseArgument);
        buildHouseInputBoundary.performAction(buildHouseInputData);
    }

    // Getter & Setters:

    public BuildHouseInputBoundary getBuildHouseInputBoundary() {
        return buildHouseInputBoundary;
    }

    public void setBuildHouseInputBoundary(BuildHouseInputBoundary buildHouseInputBoundary) {
        this.buildHouseInputBoundary = buildHouseInputBoundary;
    }

    public String isConfirm() {
        return buildHouseArgument;
    }
}
