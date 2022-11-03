package Banco;

public class Endereco {
        private String rua;
        private String cep;
        private int num_Da_Casa;
        private String bairro;
        private String cidade;
        private String uf;

        public Endereco(String rua, String cep, int num_Da_Casa, String bairro, String cidade, String uf) {
            this.rua = rua;
            this.cep = cep;
            this.num_Da_Casa = num_Da_Casa;
            this.bairro = bairro;
            this.cidade = cidade;
            this.uf = uf;

        }
        public Endereco() {
        } 
        
        public Endereco(String rua2, char[] cep2, int numeroDaCasa, String bairro2, String cidade2, String estado) {
        }
        public String getBairro() {
            return bairro;
        }
        public void setBairro(String bairro) {
            this.bairro = bairro;
        }
        public String getCidade() {
            return cidade;
        }
        
        public void setCidade(String cidade) {
            this.cidade = cidade;
        }
        public String getUf() {
            return uf;
        }
        public void setUf(String uf) {
            this.uf = uf;
        }
        public String getCep() {
            return cep;
        }
        public void setCep(String cep) {
            this.cep = cep;
        }
        public String getRua() {
            return rua;
        }

        public int getNum_Da_Casa() {
            return num_Da_Casa;
        }
     
        }
        

