package mc322.lab03;

public class AquarioLombriga {
	int sizeAquario;
    int sizeLombriga;
    int posLombriga;
    int headLombriga;
    char[] aquario;
    
    AquarioLombriga(int sizeAquario, int sizeLombriga, int posLombriga) {
        this.sizeLombriga = sizeLombriga;
        this.sizeAquario = sizeAquario;
        this.posLombriga = posLombriga;
        this.headLombriga = (posLombriga + sizeLombriga) - 1;
        
        if(sizeLombriga > sizeAquario){
            this.sizeAquario = sizeLombriga + 5;
            this.aquario = new char[this.sizeAquario];
        }
        else if(sizeLombriga < sizeAquario && headLombriga > sizeAquario){
            this.posLombriga = 1;
            this.headLombriga = (this.posLombriga + sizeLombriga) - 1;
            this.sizeAquario = sizeAquario;
            this.aquario = new char[this.sizeAquario];
        }
        else {
            this.aquario = new char[this.sizeAquario];
        }
        for(int i = 0; i < this.sizeAquario; i++) {
            if(i < this.posLombriga - 1 || i > this.headLombriga - 1)
                aquario[i] = '#';
            else if(i >= this.posLombriga - 1 && i < this.headLombriga - 1)
                aquario[i] = '@';
            else
                aquario[i] = 'O';
        }
    }
    
    char[] crescer() {
        
        if(sizeLombriga == sizeAquario){
            System.out.println("Não consigo mais crescer !!");
            return aquario;
        }
        
        else if(headLombriga > posLombriga){
            aquario[posLombriga - 2] = '@';
            this.posLombriga = posLombriga - 1;
        }
        else{
            aquario[posLombriga] = '@';
            this.posLombriga = posLombriga + 1;
        }
        this.sizeLombriga += 1;
        
        return aquario;
    }
    
    char[] mover() {
        if(headLombriga == 1 || headLombriga == 8)
            return virar();
        else
            if(headLombriga > posLombriga){
                aquario[headLombriga] = 'O';
                aquario[headLombriga - 1] = '@';
                aquario[posLombriga - 1] = '#';
                this.headLombriga += 1;
                this.posLombriga += 1;
            }
        
            else{
                aquario[headLombriga - 2] = 'O';
                aquario[headLombriga - 1] = '@';
                aquario[posLombriga - 1] = '#';
                this.headLombriga -= 1;
                this.posLombriga -= 1;
                
            }
        return aquario;
    }
    
    char[] virar() {
        aquario[headLombriga - 1] = '@';
        aquario[posLombriga - 1] = 'O';
        int novaPos = headLombriga;
        this.headLombriga = posLombriga;
        this.posLombriga = novaPos;
        
        return aquario;
    }
    
    void apresenta() {
        System.out.println(aquario);
    }
}
