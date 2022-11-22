package ViewModel;

/**
 * The MainViewModel is the view model that contains a reference to three view models: the board panel view model, the
 * player panel view model, and the command panel view model. While each view component should only have access to
 * their corresponding view models, the main view model should be accessible by all use cases.
 */
public class MainViewModel {
    private BoardPanelViewModel boardPanelVM;
    private PlayerPanelViewModel playerPanelVM;
    private CommandPanelViewModel commandPanelVM;


}
