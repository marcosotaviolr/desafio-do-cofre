// Marcos Otavio Lima Resende. RA = 1252211621066
// Samuel Gutierrez Cuellar. RA = 1261929254

public class Cofre {

    private int senha;
    private boolean trancado;
    private boolean bloqueado;
    private int tentativasFalhas;
    private String itens;

    public Cofre(int senha) {
        this.senha = senha;
        this.trancado = false;
        this.bloqueado = false;
        this.tentativasFalhas = 0;
        this.itens = "";
    }

    public void guardarItens(String itens) {
        if (!trancado) {
            this.itens = itens;
        } else {
            System.out.println("Cofre trancado.");
        }
    }

    public void trancar() {
        if (!trancado) {
            trancado = true;
            System.out.println("Cofre trancado com sucesso.");
        }
    }

    public void destrancar(int senhaDigitada) {
        if (trancado && !bloqueado) {
            if (senhaDigitada == senha) {
                trancado = false;
                tentativasFalhas = 0;
                System.out.println("Cofre destrancado.");
            } else {
                tentativasFalhas++;
                System.out.println("Senha incorreta.");
                if (tentativasFalhas == 3) {
                    bloqueado = true;
                    System.out.println("Cofre bloqueado por segurança.");
                }
            }
        }
    }

    public String visualizarItens() {
        if (!trancado) {
            return itens;
        } else {
            System.out.println("Cofre trancado.");
            return null;
        }
    }

    public void retirarItem() {
        if (!trancado) {
            this.itens = "";
            System.out.println("Cofre vazio.");
        }
    }

}
