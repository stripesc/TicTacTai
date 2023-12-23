public class tictactoe {
    public static void main(String[] args) {
        System.out.println("helo");
        Board game = new Board();
        game.play('x', "1,2");
        game.play('o', "2,2");
        game.play('x', "1,0");
        game.play('x', "1,0");
        game.play('o', "0,2");
        System.out.println(game.display());
        System.out.println(game.moves());
    }
}
