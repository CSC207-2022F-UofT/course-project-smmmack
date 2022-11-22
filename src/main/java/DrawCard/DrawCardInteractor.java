package DrawCard;

//add the imports I need from entities and or the other classes

import MainEntities.Campaign;

public class DrawCardInteractor implements DrawCardInputBoundary {
    private Campaign campaign;
    private DrawCardOutputBoundary outputBoundary;

    @Override
    public DrawCardOutputData create(DrawCardInputData input) throws Exception {
        // add stuff in here like the messages that should be showed like u lost this much money or something like that
        return null;
    }
}
