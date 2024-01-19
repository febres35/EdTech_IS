package test.practica9.a;

class GraphicsMastermind extends GameMastermind{

    private GraphicsMastermind() {
        super();
        this.graphicsView = new GraphicsView(this.board);
    }

    private void play() {
        do {
            this.graphicsView.start();
            this.graphicsView.play();
        } while (this.graphicsView.resume());
    
    }
    public static void main(String[] args) {
        new GraphicsMastermind().play();
    }
}
   