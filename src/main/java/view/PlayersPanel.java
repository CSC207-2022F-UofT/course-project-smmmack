package view;

import viewmodel.PlayerPanelVMListener;
import viewmodel.PlayerPanelViewModel;
import viewmodel.PlayerViewModel;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class PlayersPanel extends JPanel implements PlayerPanelVMListener {

    public PlayersPanel() {
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        this.add(new JLabel("This is the player Panel"));
        this.setSize(700, 200);
    }

    @Override
    public void performAction(PlayerPanelViewModel viewModel) {
        this.removeAll();
        for (PlayerViewModel playerVM: viewModel.getPlayerVMs()) {
            addPlayerCard(playerVM.getName(), playerVM.getCash(), playerVM.getJailTurn(),
                    playerVM.getPropertyAbbrs(), playerVM.getColor());
        }
    }

    public void addPlayerCard(String name, int cash, int jailTurn, List<String> properties, Color color) {
        this.add(getPlayerCard(name, cash, jailTurn, properties, color));
    }

    public JPanel getPlayerCard(String name, int cash, int jailTurn, List<String> properties, Color color) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setSize(200, 200);

        // Add labels to the player card
        JLabel nameLabel = new JLabel(name);
        nameLabel.setForeground(color);
        panel.add(nameLabel);

        // Add cash label to the player card
        panel.add(new JLabel("CASH: " + cash));

        // Add property labels to the player card
        StringBuilder propertyList = new StringBuilder("LAND: ");
        if (properties.size() == 0) {
            propertyList.append("None");
        } else {
            for (String abbr: properties) {
                propertyList.append(abbr);
                propertyList.append(", ");
            }
            propertyList.delete(propertyList.length() - 2, propertyList.length());
        }
        panel.add(new JLabel("<html>" + propertyList.toString() + "</html>"));

        // Add jail label to player
        if (jailTurn > 1) {
            panel.add(new JLabel("In jail for: " + jailTurn + " turn(s)"));
        }

        return panel;
    }
}
