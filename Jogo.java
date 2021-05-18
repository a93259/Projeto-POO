import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class Jogo{

    private String equipaCasa;
    private String equipaFora;
    private int golosCasa;
    private int golosFora;
    private Map<Integer,Jogador> jogadoresCasa;
    private Map<Integer,Jogador> jogadoresFora;
    private Map<Integer,Integer> substituicoesCasa = new HashMap<>();
    private Map<Integer,Integer> substitucoesFora = new HashMap<>();
    private final LocalDate data;

    //----------------------------------------------------------Construtores------------------------------------------------------------

    public Jogo (String ec, String ef, int gc, int gf, LocalDate d,  Map<Integer,Jogador> jc, Map<Integer, Integer> sc,  Map<Integer,Jogador> jf, Map<Integer, Integer> sf){
        equipaCasa = ec;
        equipaFora = ef;
        golosCasa = gc;
        golosFora = gf;
        data = d;
        jogadoresCasa = new HashMap<>(jc);
        jogadoresFora = new HashMap<>(jf);
        substituicoesCasa = new HashMap<>(sc);
        substitucoesFora = new HashMap<>(sf);
    }

    //----------------------------------------------------------Gets e Sets------------------------------------------------------------
    public String getEquipaCasa() {
        return equipaCasa;
    }

    public void setEquipaCasa(String equipaCasa) {
        this.equipaCasa = equipaCasa;
    }

    public String getEquipaFora() {
        return equipaFora;
    }

    public void setEquipaFora(String equipaFora) {
        this.equipaFora = equipaFora;
    }

    public int getGolosCasa() {
        return golosCasa;
    }

    public void setGolosCasa(int golosCasa) {
        this.golosCasa = golosCasa;
    }

    public int getGolosFora() {
        return golosFora;
    }

    public void setGolosFora(int golosFora) {
        this.golosFora = golosFora;
    }

    public Map<Integer, Jogador> getJogadoresCasa() {
        return jogadoresCasa;
    }

    public void setJogadoresCasa(Map<Integer, Jogador> jogadoresCasa) {
        this.jogadoresCasa = jogadoresCasa;
    }

    public Map<Integer, Jogador> getJogadoresFora() {
        return jogadoresFora;
    }

    public void setJogadoresFora(Map<Integer, Jogador> jogadoresFora) {
        this.jogadoresFora = jogadoresFora;
    }

    public Map<Integer, Integer> getSubstituicoesCasa() {
        return substituicoesCasa;
    }

    public void setSubstituicoesCasa(Map<Integer, Integer> substituicoesCasa) {
        this.substituicoesCasa = substituicoesCasa;
    }

    public Map<Integer, Integer> getSubstitucoesFora() {
        return substitucoesFora;
    }

    public void setSubstitucoesFora(Map<Integer, Integer> substitucoesFora) {
        this.substitucoesFora = substitucoesFora;
    }

    public LocalDate getData() {
        return data;
    }

    //-------------------------------------------------------MetodosBase-----------------------------------------------

    public String toString() {
        return  "Jogo:" + equipaCasa + " - " + equipaFora;
        //+ " -> " + substituicoesCasa.toString()
        //+ " -> " + substitucoesFora.toString();
    }

    //--------------------------------------------------------Metodos-------------------------------------------------

    public static Jogo parse(String input, Map<Integer,Jogador> jogadores){
        String[] campos = input.split(",");
        String[] data = campos[4].split("-");
        Map<Integer,Jogador> jc = new HashMap<>();
        Map<Integer,Jogador> jf = new HashMap<>();
        Map<Integer, Integer> subsC = new HashMap<>();
        Map<Integer, Integer> subsF = new HashMap<>();
        for (int i = 5; i < 16; i++){
            int nr = Integer.parseInt(campos[i]);
            jc.put(nr,jogadores.get(nr));
        }
        for (int i = 16; i < 19; i++){
            String[] sub = campos[i].split("->");
            subsC.put(Integer.parseInt(sub[0]), Integer.parseInt(sub[1]));
        }
        for (int i = 19; i < 30; i++){
            int nr = Integer.parseInt(campos[i]);
            jf.put(nr,jogadores.get(nr));
        }
        for (int i = 30; i < 33; i++){
            String[] sub = campos[i].split("->");
            subsF.put(Integer.parseInt(sub[0]), Integer.parseInt(sub[1]));
        }
        return new Jogo(campos[0], campos[1], Integer.parseInt(campos[2]), Integer.parseInt(campos[3]),
                LocalDate.of(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2])),
                jc, subsC, jf, subsF);
    }

}
