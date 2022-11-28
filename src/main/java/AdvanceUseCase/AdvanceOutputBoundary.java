package AdvanceUseCase;

public interface AdvanceOutputBoundary {
    /**
     * Either prompts the user to enter a valid input or displays the results of a dice roll.
     * @param outputData
     */
    void create(AdvanceOutputData outputData);

}
