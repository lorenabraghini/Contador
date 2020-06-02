import java.io.*;
import java.util.*;

public class Contador {

    public static void main(String[] args) throws IOException{
        
        String entrada = args[0];
        String saida = args[1];

        try {

            File file = new File(entrada);
            Scanner sc = new Scanner(file);

            LinkedList<Elemento> elementos = new LinkedList<>();

            System.out.println("Iniciando leitura do arquivo");
            int linha = 0;

            while(sc.hasNext()){
                
                linha++;
                System.out.println("Lendo linha " + linha + " do arquivo");

                Elemento e = new Elemento(sc.nextLine());
                if(!elementos.contains(e)) elementos.add(e);
            }
            sc.close();

            FileWriter arq = new FileWriter(saida);
            PrintWriter imprime = new PrintWriter(arq);

            imprime.println("O elemento x aparece y vezes no arquivo");
            for(Elemento e : elementos) imprime.println(e.getValor() + " " + e.getQtd());
            imprime.close();

            System.out.println("Fim!");           

        } catch (FileNotFoundException e) {

            System.out.println("Arquivo " + entrada + " não encontrado.");
            System.exit(1);
        }        
    }
    
}

class Elemento {

    private String valor;
    private int qtd;

    public Elemento(String valor){

        this.valor = valor;
        qtd = 1;
    }

    public void setQtd() {

        qtd++;
    }

    public String getValor() {

        return valor;
    }

    public int getQtd () {

        return qtd;
    }

    @Override
    public boolean equals(Object o) {

        if(o instanceof Elemento){
            
            Elemento e = (Elemento) o;
            if(e.getValor().equals(this.valor)) {

                e.setQtd();
                return true;
        }
    }

        return false;
    }
}
