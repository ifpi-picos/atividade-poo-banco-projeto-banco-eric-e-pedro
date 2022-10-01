package Banco;
public class Endereco {
    
    private String rua;
    private String cep;
    private int numeroDaCasa;
    private String bairro;
    private String cidade;
    private String UF;



    public Endereco() {
    }
    public Endereco(String rua, String cep, int numeroDaCasa, String bairro, String cidade, String UF) {
        this.rua = rua;
        this.cep = cep;
        this.numeroDaCasa = numeroDaCasa;
        this.bairro = bairro;
        this.cidade = cidade;
        this.UF = UF;
    }
    public String getRua() {
        return rua;
    }
    public String getCep() {
        return cep;
    }

    public int getNumeroDaCasa() {
        return numeroDaCasa;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }


    public String getUF() {
        return UF;
    }
    public void setRua(String rua) {
        this.rua = rua;
    }
    public void setCep(String cep) {
        this.cep = cep;
    }
    public void setNumeroDaCasa(int numeroDaCasa) {
        this.numeroDaCasa = numeroDaCasa;
    }
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    public void setEstado(String UF) {
        this.UF = UF;
    }

}
