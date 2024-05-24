package ps2.restapidb;

import javax.persistence.*;

@Entity
public class Participante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_participante;
    private String nome;
    private String CPF;

    @ManyToOne
    @JoinColumn(name = "evento_id")
    private Evento evento;

    // Getters and setters

    public long getId_participante() {
        return id_participante;
    }

    public void setId_participante(long id_participante) {
        this.id_participante = id_participante;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }
}
