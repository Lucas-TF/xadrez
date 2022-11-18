package view;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import model.piece;

// Create by @Lucastavaresfds
public class jPiece extends JLabel {
    
    private piece piece;

    public jPiece(piece piece) {
        this.piece = piece;
        this.setIcon(new ImageIcon(piece.getImage()));
    }
    public piece getPiece() {
        return this.piece;
    }
}
