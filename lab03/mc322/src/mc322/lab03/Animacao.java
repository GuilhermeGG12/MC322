package mc322.lab03;

public class Animacao {
    char[] seq;
    int aa;
    int ll;
    int pp;
    int length;
    AquarioLombriga lombriga;
    
    
    Animacao(String seq) {
        this.length = seq.length();
        this.seq = seq.toCharArray();
        this.aa = 10 * Integer.parseInt(String.valueOf(this.seq[0])) + Integer.parseInt(String.valueOf(this.seq[1]));
        this.ll = 10 * Integer.parseInt(String.valueOf(this.seq[2])) + Integer.parseInt(String.valueOf(this.seq[3]));
        this.pp = 10 * Integer.parseInt(String.valueOf(this.seq[4])) + Integer.parseInt(String.valueOf(this.seq[5]));
        this.lombriga = new AquarioLombriga(aa, ll, pp);
        this.lombriga.apresenta();
    }
    
    void apresenta() {
        System.out.println(this.lombriga.aquario);
    }
    
    void passo() {
        for(int i = 6; i < this.length; i++) {
            switch(this.seq[i]) {
                case 'M':
                    this.lombriga.mover();
                    apresenta();
                    break;
                case 'C':
                    this.lombriga.crescer();
                    apresenta();
                    break;
                case 'V':
                    this.lombriga.virar();
                    apresenta();
                    break;
            }
        }
    }
}