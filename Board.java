import java.util.ArrayList;
import java.util.Objects;

public class Board {
    private final ArrayList<ArrayList<Character>> state;
    private final ArrayList<String> legalMoves;

    public Board() {
        state = new ArrayList<>();
        legalMoves = new ArrayList<>();
        for (int i = 0; i < 3; i++){
            state.add(new ArrayList<>());
            state.get(i).add(' ');
            legalMoves.add(i+",0");
            state.get(i).add(' ');
            legalMoves.add(i+",1");
            state.get(i).add(' ');
            legalMoves.add(i+",2");
        }
    }

    public void play(char piece, String location){
        location = location.replaceAll("\\s+","");
        boolean legal = false;
        for (int i = 0; i < legalMoves.size(); i++){
            if (Objects.equals(legalMoves.get(i), location)) {
                legal = true;
                break;
            }
        }
        if (!legal){
            System.out.println("Illegal move");
            return;
        }
        if (piece == 'x'){
            state.get(Character.getNumericValue(location.charAt(0))).set(Character.getNumericValue(location.charAt(2)), piece);
            for (int i = 0; i < legalMoves.size(); i++){
                if (Objects.equals(legalMoves.get(i), location)){
                    legalMoves.remove(i);
                }
            }
        }
        else if (piece == 'o'){
            state.get(Character.getNumericValue(location.charAt(0))).set(Character.getNumericValue(location.charAt(2)), piece);
            for (int i = 0; i < legalMoves.size(); i++){
                if (Objects.equals(legalMoves.get(i), location)){
                    legalMoves.remove(i);
                }
            }
        }
        else {
            System.out.println("Bad command");
        }
    }

    public String display() {
        String output = "";
        for (int i = 0; i < 3; i++){
            output+= "| " + state.get(i).get(0) + " | " + state.get(i).get(1) + " | " + state.get(i).get(2) + " |\n";
        }
    return output;
    }

    public ArrayList<String> moves(){
        return legalMoves;
    }
}
