//Gerson Henrique de Araujo Junior
//29-03-2021

public class Jogador
{
    private static final int Guarda_Redes = 0;
    private static final int Defesa = 1;
    private static final int Medio = 2;
    private static final int Avancado = 3;
    private static final int Lateral = 4;
    
    private String nome;
    private int posicao;
    private double valorJogador;
    private int velocidade;
    private int resistencia;
    private int destreza;
    private int implusao;
    private int cabecear;
    private int remate;
    private int passe;
    private int elasticidade;
    
    //Construtor por omissão
    public Jogador(){
        this.nome = "";
        this.posicao = -1;
        this.valorJogador = 0;
        this.velocidade = 0;
        this.resistencia = 0;
        this.destreza = 0;
        this.implusao = 0;
        this.cabecear = 0;
        this.remate = 0;
        this.passe = 0;
        this.elasticidade = 0;
    }
    
    //Construtor parametrizado
    public Jogador(int posicao,double valorJogador,int velocidade,int resistencia,int destreza,int implusao,int cabecear,int remate,int passe,int elasticidade){
        this.posicao = posicao;
        this.valorJogador = valorJogador;
        this.velocidade = velocidade;
        this.resistencia = resistencia;
        this.destreza = destreza;
        this.implusao = implusao;
        this.cabecear = cabecear;
        this.remate = remate;
        this.passe = passe;
        this.elasticidade = elasticidade;
    }
    
    //Construtor de copia
    public Jogador(Jogador umJogador){
        this.posicao = umJogador.getPosicao();
        this.valorJogador = umJogador.getValorJogador();
        this.velocidade = umJogador.getVelocidade();
        this.resistencia = umJogador.getResistencia();
        this.destreza = umJogador.getDestreza();
        this.implusao = umJogador.getImplusao();
        this.cabecear = umJogador.getCabecear();
        this.remate = umJogador.getRemate();
        this.passe = umJogador.getPasse();
        this.elasticidade = umJogador.getElasticidade();
    }
    
    public int getPosicao(){
        return this.posicao;
    }
    
    public double getValorJogador(){
        return this.valorJogador;
    }
    
    public int getVelocidade(){
        return this.velocidade;
    }
    
    public int getResistencia(){
        return this.resistencia;
    }
    
    public int getDestreza(){
        return this.destreza;
    }
    
    public int getImplusao(){
        return this.implusao;
    }
    
    public int getCabecear(){
        return this.cabecear;
    }
    
    public int getRemate(){
        return this.remate;
    }
    
    public int getPasse(){
        return this.passe;
    }
    
    public int getElasticidade(){
        return this.elasticidade;
    }
    
    //--------------------------------------------------------------------------\\
    
    public void setPosicao(int posicao){
        this.posicao = posicao;
    }
    
    public void setValorJogador(double valorJogador){
        this.valorJogador = valorJogador;
    }
    
    public void setVelocidade(int velocidade){
        this.velocidade = velocidade;
    }
    
    public void setResistencia(int resistencia){
        this.resistencia = resistencia;
    }
    
    public void setDestreza(int destreza){
        this.destreza = destreza;
    }
    
    public void setImplusao(int implusao){
        this.implusao = implusao;
    }
    
    public void setCabecear(int cabecear){
        this.cabecear = cabecear;
    }
    
    public void setRemate(int remate){
        this.remate = remate;
    }
    
    public void setPasse(int passe){
        this.passe = passe;
    }
    
    public void setElasticidade(int elasticidade){
        this.elasticidade = elasticidade;
    }
    
    //Metodo para saber o overall do Jogador
    public double ValorJogador(){
        if(posicao == Guarda_Redes){
            this.valorJogador = 0.6*this.elasticidade + 0.1*this.remate + 0.3*this.destreza;
        }
        if(posicao == Defesa){
            this.valorJogador = 0.5*this.destreza+0.3*this.passe + 0.2*(this.velocidade + this.resistencia + this.implusao + this.remate + this.cabecear);
        }
        if(posicao == Medio){
            this.valorJogador = 0.7*(this.passe+this.destreza+this.velocidade) + 0.3*(this.resistencia + this.cabecear + this.remate+this.implusao);
        }
        if(posicao == Avancado){
            this.valorJogador = 0.8*(this.implusao + this.remate + this.cabecear + this.resistencia) + 0.1*this.velocidade + 0.1*(this.destreza+this.passe);
        }
        if(posicao == Lateral){
            this.valorJogador = 0.7*(this.implusao + this.velocidade + this.resistencia) + 0.2*(this.cabecear + this.remate) + 0.1*(this.destreza + this.passe);
        }
        return valorJogador;
    }
    
}
