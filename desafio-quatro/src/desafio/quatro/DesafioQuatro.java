/**
 * 
 * Este algoritmo não pode ser feito com algoritmo guloso já que não 
 * atente aos requisitos de matroide.
 * Para trazer o resultado eficiente é preciso utilizar o método dinâmico
 * a partir de uma árvore recursiva (Função: troco(...))
 * 
 */

package desafio.quatro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author lucas
 */
public class DesafioQuatro {
    
    static int troco(int valor, List<Integer> cedulas, Stack<Integer> solucao, List<Integer[]> solucoes){
        if ((valor<0)||(cedulas.isEmpty()))
            return 0;
        if (valor==0){
            solucoes.add(solucao.toArray(new Integer[solucao.size()]));
            return 1;
        }
        
        Integer cedula = cedulas.get(0);
        solucao.push(cedula);
        int valor1 = troco(valor-cedula, cedulas, solucao, solucoes);
        solucao.pop();
        
        List<Integer> cedulasAtual = new ArrayList<>(cedulas);
        cedulasAtual.remove(cedula);
        int valor2 = troco(valor, cedulasAtual, solucao, solucoes);
        
        return valor1 + valor2;
        
    }    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int valor, nNotas;
        Scanner input = new Scanner(System.in);
        System.out.println("Digite o valor que deseja trocar: ");
        valor = input.nextInt();
        
        List<Integer> cedulas = new ArrayList<>();
        Stack<Integer> solucao = new Stack<>();
        List<Integer[]> solucoes = new ArrayList<>();
        
        System.out.println("Digite o numero de notas: ");
        nNotas = input.nextInt();
        
        for(int i=0; i<nNotas; i++){
            System.out.println("Digite o valor desta nota: ");
            int nota = input.nextInt();
            cedulas.add(nota);
        }
        
        int retorno = troco(valor, cedulas, solucao, solucoes);
        for(Integer[] sol : solucoes){
            System.out.println(Arrays.toString(sol));
        }
        
    }
    
}
