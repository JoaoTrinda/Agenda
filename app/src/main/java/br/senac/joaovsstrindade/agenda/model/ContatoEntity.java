package br.senac.joaovsstrindade.agenda.model;

public class ContatoEntity {
    private Integer id;
    private String nome;
    private String email;
    private String telefone;
    private double pontuacao;


    public ContatoEntity(String nome,String email,  String telefone, double pontuacao) {

        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.pontuacao = pontuacao;




    }

    public ContatoEntity() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public double getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(double pontuacao) {
        this.pontuacao = pontuacao;
    }

    @Override
    public String toString() {
        return
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                ", pontuacao=" + pontuacao ;

    }
}

