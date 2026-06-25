package ToDo;

import static ToDo.Status.*;

public class Tarefa  {
    private String nome;
    private String desc;
    private Status status;

    public Tarefa(){
        this.status = PENDENTE;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        //Default
        this.status = status;
    }

    @Override
    public String toString() {
        return  "Nome: " + getNome() +
                " | Descrição: " + getDesc();
    }
}
