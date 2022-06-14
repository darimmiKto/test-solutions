package Algoritm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Sorted {
	
	//Массив случайных int-ов размером 200 000 элементов, сортируем разными способами:
	//int[] array = {12, 23, 3413 , 2, 3456, 12, 435, 436, 6}; - проверим сколько оперций понадобится 
	//BUBBLE sort time: 70148 ms O(n^2) - сортировка пузыпьком. Операций 17
	//SELECTION sort time: 12935 ms O(n^2) - сортировка выбором (НЕ УСТОЙЧИВАЯ), то есть
	//меняет одинаковые значения местами. Операций 9
	//INSERT sort time: 2651 ms O(n^2) - сортировка вставками (УСТОЙЧИВАЯ),
	//то есть не меняет одинаковые значения местами
	
	// Проверим время выполнения на 1000 элементов:
	//COMB sort time: 6 ms O(n) = n log(n) - сортировка расчёской (рекомендуется использовать)
	//BUBBLE sort time: 317 ms - медленно
	//SELECTION sort: 47 ms - не плохо, но расчесткой лучше
	
	//Arrays.sort() time: 74 ms // данный метод находится в библиотеке java, он подберает нужный
	//алгоритм, тоже рекомендуется использовать
	//COMBsort sort time: 63 ms O(n) = n log(n) - сортировка расчёской (рекомендуется использовать)
	//QUICKSORT sort time: 36 ms O(n log n) - быстрая сортировка (рекомендуется использовать даже на больших данных)
	//COUNTING sort time: 99 ms
	//MERGE sort time: 56 ms - сортировка слиянием
	//MERGE(non recursive) sort time: 93 ms


	//SHUTTLE sort time: 5341 ms
	//SHELLA sort time: 26127 ms
	
	
/**
 * @author Xarakiri Xan 
 *
 */
	
// Bubble sorted (сортировка пузырьком).Сложность алгоритма O(n^2)	
class BubbleSorted { 
	public static void main(String[] args) {
		int [] array = {12, 3, 234, 23, 3546, 23, 4, 23556, 43, 23, 2356}; // определение массива 
		System.out.println(Arrays.toString(array)); // выводим массив
		boolean sorted = true; // ставим флажок для того, чтобы определить, оторсирован массив до конца или нет
		while(sorted) { // цикл while
			sorted = false; // ставим флажок false
			for (int i = 1; i < array.length; i++) {
				if (array[i] < array[i - 1]) { // если вторая ячейка меньше первого, сортируем её
					swap(array, i, i - 1); // сортируем с помощью метода swap()
					sorted = true; // метод true срабатывает когда сортировка прошла через весь массив
				}
			}
		}
		System.out.println(Arrays.toString(array)); // выводим массив для проверки
	}
	
	private static void swap(int[] array, int i, int j) { // метод принимает сам массив, второй индекс и первый
		int temp = array[i]; // сохраняем в temp второй число, чтобы потом приравнять
		array[i] = array[j]; // приравниваем второе число с первым
		array[j] = temp; // приравниваем второе число с первым
	}
	// Такую сортировку лучше не использовать, cложность алгоритма O(n^2)
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////
	}
}

// Сортировка выбором (Selection Sort).Сложность алгоритма O(n^2)
class SelectionSorted {
	public static void main(String[] args) {
		int[] array = {22, 3, 34, 45, 2, 1, 4565, 35, 24}; // объявляем массив 
		System.out.println(Arrays.toString(array)); // выводим массив 
		for (int left = 0; left < array.length; left++) { // начинаем с 0
			int minInt = left; // минимальное число с инлексов left(0), [22]
			for (int i = left; i < array.length; i++) { // i = left [22]
				if (array[i] < array[minInt]) { // если 22 < 22 (false), 3 < 34 (true) - minInt = i [3]
					minInt = i; // minInt = [3]
				}
			}
			swap(array, left, minInt); // left = [22], minInt = [3]
		}
		System.out.println(Arrays.toString(array)); // станет [3, 22, 34, 45, 2, 1, 4565, 34, 24]
		// алгоритм будет повторяться пока left не дошёл до конца
	}
	
	private static void swap(int[] array, int i, int j) { // метод принимает сам массив, второй индекс и первый
		int temp = array[i]; // сохраняем в temp второе число, чтобы потом приравнять
		array[i] = array[j]; // приравниваем первое число со вторым
		array[j] = temp; // приравниваем второе число с первым
	}
	// Такую сортировку лучше не использовать, cложность алгоритма O(n^2)
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////
}

// Сортировка вставками (Insertion Sort). Сложность алгоритма O(n^2)
class InsertionSort {
	public static void main(String[] args) {
		int[] array = {12, 23, 3413 , 2, 3456, 12, 435, 436, 6}; // объявляем массив
		System.out.println(Arrays.toString(array)); // смотрим как выглядил массив до сортировки
		swap(array); // помещаем массив в метод swap() для сортировки
		System.out.println(Arrays.toString(array)); // смотри как выглядит массив после сортировки
	}
	
	private static void swap(int[] array) { // метод принимает просто массив
		for (int i = 1; i < array.length; i++) { // начинаем с первого элемента, так как 0-ой элемент отсортированный
			int value = array[i]; // сохраняем в value первое значение не отсортированного списка
			int j = i; // в j сохраняем индекс не отсортированного массива
			while (j > 0 && array[j - 1] > value) { // проверяем, j > 0 и проверяет отсортированное сзначение > не
			    // осортированного массива, если да, то перемещаем, это больше значение вперед, и так до конца, пока
			    // цикл while не закончится
				array[j] = array[j - 1]; // так проиходит перемещение большого элемента отсортированного спика - вперёд
				j--; // уменьшаем j для проверки всех элементов отсортированного массива с не отсортированным массивом
			}
			array[j] = value; // сохраняет элеммент в такую позицую, на которой закончился цикл while, число value
		}
	}
	// Данная сортировка является стандарная, её можно использовать, но она всё равно имеет сложность O(n^2)
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////
}

// Сортировка расчёской (Comb Sort). Сложность алгоритма O(n) = n log(n)
class CombSort {
	public static void main(String[] args) {
		int[] array = {12, 4, 234, 23, 546}; // допустим у нас есть массив который нужно будет отсортировать
		System.out.println(Arrays.toString(array)); // смотрим как выглядил массив до сортировки
		swap(array); // помещаем массив в метод swap() для сортировки
		System.out.println(Arrays.toString(array)); // смотри как выглядит массив после сортировки
	}
	
	private static void swap(int[] array) { // метод принимает обычынй массив
		int gap = array.length; // gap - нужен для шагов
		boolean sorted = true; // проверяет, не закончил ли алгоритм сортировку
		while(sorted || gap != 1) { // будет продолжать пока не будет сортироваться или шагов для сортировки не равен одному
			if (gap > 1) { // проверяет, если gap больше одного, то
				gap = (int) (gap / 1.2473309); // то делим на число 1.2473309 и узнаем шаги
				// допустим длина нашего массива 5, от 12 до 546 нам нужно пройти 4 шага
			} else {
				gap = 1; // если gap меньше 1, то он равен 1
			}
			sorted = false; // массив ещё не отсортирован
			for (int i = gap; i < array.length; i++) { // он проверяет, если последнее значение больше первого
				// значения, он не заходит в if и выходит из for и уменьшает gap для проверки следующих значений;
				// если последнее меньше первого значения, он меняет их местами, обратно выходии из for и меняет gap.
				// когда сортировка с помощью шагов(gap) закончилась, то после идёт обычная сортировка пузырьком
				if (array[i] < array[i - gap]) {  
					int temp = array[i]; // сохраняем в temp второе число, чтобы потом приравнять
					array[i] = array[i - gap]; // приравниваем первое число со вторым
					array[i - gap] = temp; // приравниваем второе число с первым
					sorted = true; // если больше нечего сортировать, цикл заканчивается
				}
			}
		}
	}
}

// Быстрая сортировка (Quick Sort). Сложность алгоритма O(n log (n))
class QuickSort {
	public static void main(String[] args) {
		int[] array = {12, 43, 54, 2, 65, 34, 8}; // допустим у нас есть массив который нужно будет отсортировать
 		System.out.println(Arrays.toString(array)); // смотрим какой массив был до сортировки
		quickSort(array, 0, array.length - 1); // наченимаем сортировку
		System.out.println(Arrays.toString(array)); // смотрим какой массив стал после сортировки 
		
	}
	
	private static void quickSort(int[] array, int from, int to) { // метод принимаем массив, первый индекс и последний
		if (from < to) { // если первый индекс меньше последнего, то сортируем, если массив состоит из одно элемента
			// не сортируем
			int divideIndex = partition(array, from, to); // делим массив на две части, на те которые меньше 
			// divideIndex и на те которые больше
			quickSort(array, from, divideIndex - 1); // после мы сортируем левую часть(где находятся маньше значение)
			quickSort(array, divideIndex, to); // после сортируем првую часть(где находятся большие значения)
			// рекурсивный метод будет продолжаться пока массив не будет отсортирован до конца
		}
	}
	
	private static int partition(int[] array, int from, int to) { // метод принимат массв, первый индекс и последний
		int rightIndex = to; // последний индекс массива сохраняем под названием rightIndex
		int leftIndex = from; // первый индекс массива сохраняем под названием leftIndex
		
		int pivot = array[from]; // в pivot сохраняем то значение, на которое будем отталкиваться
		// если значения в массиве меньше данного числа, они идут в левую часть, если больше в правую
		while (leftIndex <= rightIndex) { // цикл будет повторяться, пока левая и првая часть не встретятся 
			
			while (array[leftIndex] < pivot) { // левая часть сдвигается вправо, цикл остановится 
				leftIndex++; // когда найдёт значение меньше pivot
			} 
			while (array[rightIndex] > pivot) { // правая часть сдивается влево, цикл остановится 
				rightIndex--; // когда найдёт значение больше pivot
			} 
			if (leftIndex <= rightIndex) { // если проверка всех значений не прошла, заходит в if
				swap(array, rightIndex, leftIndex); // меняет местами большее значение с меньшим
				leftIndex++; // индекс шагает, так как этот элемент уже был проверене и отсортирован
				rightIndex--; // индекс шагает, так как этот элемент уже был проверене и отсортирован 
			}
		}
		return leftIndex; // возращает новое значение на которое будет отталкиваться
	}
	

	private static void swap(int[] array, int index, int indexOne) { // метод принимает массив и индексы чисел 
		int temp = array[index]; // сохраняем в temp второе число, чтобы потом приравнять
		array[index] = array[indexOne]; // приравниваем первое число со вторым
		array[indexOne] = temp; // приравниваем второе число с первым
	}
}


