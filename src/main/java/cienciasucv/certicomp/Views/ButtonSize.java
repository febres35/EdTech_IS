package cienciasucv.certicomp.Views;

import java.awt.Dimension;

public enum ButtonSize {

    SMALL(new Dimension(100, 25), 12),
    MEDIUM(new Dimension(125, 40), 14),
    LARGE(new Dimension(200, 50), 16),
    WIDER(new Dimension(150, 25), 12);

    private final Dimension dimension;
    private final int fontSize;

    ButtonSize(Dimension dimension, int fontSize) {
        this.dimension = dimension;
        this.fontSize = fontSize;
    }

    public Dimension getDimension() {
        return dimension;
    }

    public int getFontSize() {
        return fontSize;
    }
}