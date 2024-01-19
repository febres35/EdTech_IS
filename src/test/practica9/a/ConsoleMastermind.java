package test.practica9.a;

class ConsoleMastermind extends GameMastermind{
    private ConsoleView;
    
    private ConsoleMastermind() {
        super();
        this.consoleView = new ConsoleView(this.board);
    }
    private void play() {
        do {
            this.consoleView.start();
            this.consoleView.play();
        } while (this.consoleView.resume());
    }
    public static void main(String[] args) {
        new ConsoleMastermind().play();
    }
}

