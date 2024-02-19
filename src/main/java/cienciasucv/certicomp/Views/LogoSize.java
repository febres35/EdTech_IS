package cienciasucv.certicomp.Views;

public enum LogoSize {
    SMALL("/images/CertiCompSmall.png"),
    MEDIUM("/images/CertiCompMedium.png"),
    LARGE("/images/CertiCompLarge.png");

    private final String imagePath;

    LogoSize(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getImagePath() {
        return imagePath;
    }
}
