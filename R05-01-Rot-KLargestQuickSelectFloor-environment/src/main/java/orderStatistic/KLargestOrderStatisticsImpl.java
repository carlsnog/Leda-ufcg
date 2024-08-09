package orderStatistic;

import util.Util;

/**
 * Uma implementacao da interface KLargest que usa estatisticas de ordem para 
 * retornar um array com os k maiores elementos de um conjunto de dados/array.
 * 
 * A k-esima estatistica de ordem de um conjunto de dados eh o k-esimo menor
 * elemento desse conjunto. Por exemplo, considere o array [4,8,6,9,12,1]. 
 * A 3a estatistica de ordem eh 6, a 6a estatistica de ordem eh 12.
 * 
 * Note que, para selecionar os k maiores elementos, pode-se pegar todas as 
 * estatisticas de ordem maiores que k. 
 * 
 * Requisitos do algoritmo:
 * - DEVE ser in-place. Porem, voce pode modificar o array original.
 *   Voce pode criar ainda um array de tamanho k que vai armazenar apenas
 *   os elementos a serem retornados.
 * - Voce DEVE usar alguma ideia de algoritmo de ordenacao visto em sala 
 *   para calcular estatisticas de ordem.
 * - Se a entrada for invalida, deve-se retornar um array vazio (por exemplo,
 *   ao solicitar os 5 maiores elementos em um array que soh contem 3 elementos).
 *   Este metodo NUNCA deve retornar null.
 * 
 * @author campelo and adalberto
 *
 * @param <T>
 */
public class KLargestOrderStatisticsImpl<T extends Comparable<T>> implements KLargest<T>{

	@Override
	public T[] getKLargest(T[] array, int k) {
		T[] result;
		if (k < 1 || k > array.length) {result = (T[]) new Comparable[0];}
		else {
			quickSort(array, 0, array.length-1);
			result = (T[]) new Comparable[k];
			int i = array.length;

			for (int j = 0; j < k; j++) {
				result[j] = orderStatistics(array, i--);
			}
		}
		return result;
	}

	/**
	 * Metodo que retorna a k-esima estatistica de ordem de um array, usando
	 * a ideia de algum algoritmo de ordenacao visto em sala. Caso nao exista 
	 * a k-esima estatistica de ordem, entao retorna null.
	 * 
	 * Obs: o valor de k deve ser entre 1 e N.
	 * 
	 * @param array
	 * @param k
	 * @return
	 */
	public T orderStatistics(T[] array, int k){
		T result = null;
		if (k <= array.length && k > 0) {
			result = array[k-1];
		}
		return result;
	}

	public void quickSort(T[] array, int leftIndex, int rightIndex) {
		if (leftIndex < rightIndex) {
			int indexPivot = partition(array, leftIndex, rightIndex);
			quickSort(array, leftIndex, indexPivot-1);
			quickSort(array, indexPivot+1, rightIndex);
		}
	}

	public int partition(T[] array, int leftIndex, int rightIndex) {
		int ini = leftIndex+1;
		int fim = rightIndex;
		T pivot = array[leftIndex];
		while(ini <= fim) {
			while(ini <= fim && pivot.compareTo(array[ini]) >= 0) {
				ini++;
			}
			while(ini <= fim && pivot.compareTo(array[fim]) < 0) {
				fim--;
			}
			if (ini < fim) {
				Util.swap(array, ini, fim);
			}
		}
		Util.swap(array, leftIndex, fim);
		return fim;
	}
}
