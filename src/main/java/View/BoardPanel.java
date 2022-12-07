package View;

import ViewModel.BoardPanelVMListener;
import ViewModel.BoardPanelViewModel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Board panel is the panel where we have the board.
 */
public class BoardPanel extends JPanel implements BoardPanelVMListener {
    private String boardPicPath;

    public BoardPanel() {
        this("null");
    }

    public BoardPanel(String boardPicPath) {
        this.boardPicPath = boardPicPath;
        this.setSize(700, 700);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image img;
        try {
            img = ImageIO.read(new File(boardPicPath));
        } catch (IOException e) {
            g.drawString("[No Image Found]", 100, 100);
            return;
        }
        g.drawImage(img, 0, 0, 700, 700, null);
    }

    @Override
    public void performAction(BoardPanelViewModel viewModel) {
        this.boardPicPath = viewModel.getPicPath();
        this.repaint();
    }


    //getters

    public String getBoardPicPath() {
        return boardPicPath;
    }

    //setters

    public void setBoardPicPath(String boardPicPath) {
        this.boardPicPath = boardPicPath;
    }
}
