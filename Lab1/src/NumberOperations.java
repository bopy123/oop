import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class NumberOperations {
	public static void main(String[] args) {	
		ArrayList<Number> numbers = new ArrayList<>();
		
		numbers.add(10);
		numbers.add(20.5);
		numbers.add(30);
		numbers.add(40.7);
		numbers.add(50);
		numbers.add(60.3);
		numbers.add(70);
		numbers.add(80.1);
		numbers.add(90);
		numbers.add(100.9);
		
		// 4
		System.out.print("Numbers List: ");
		System.out.println(numbers);
		
		// 5
        System.out.println("Числа у форматі цілих чисел:");
        for (Number num : numbers) {
            System.out.print(num.intValue() + " ");
        }
        
        // 6
        System.out.println("\nЧисла у форматі дробних чисел з 2ма знаками після коми:");
        for (Number num : numbers) {
        	System.out.printf("%.2f ", num.doubleValue());
        }
		
        // 7
        List<Integer> intList = new ArrayList<>();
        List<Double> doubleList = new ArrayList<>();
        
        for (Number num: numbers) {
        	if (num instanceof Integer) {
        		intList.add((Integer) num);
        	} else if (num instanceof Double) {
        		doubleList.add((Double) num);
        	}
        }
        
        // 8
        double sumOver50 = 0;
        for (Number num : numbers) {
            if (num.doubleValue() > 50) {
                sumOver50 += num.doubleValue();
            }
        }
        System.out.printf("\nСума чисел > 50: %.2f\n", sumOver50);
        
        
        // 9
        List<Double> multipliedList = new ArrayList<>();
        for (Number num : numbers) {
            multipliedList.add(num.doubleValue() * 2);
        }
        System.out.println("Список, де кожне число помножене на 2:");
        for (Double val : multipliedList) {
            System.out.printf("%.2f ", val);
        }
        
        // 10
        System.out.println("\nРезультати формули (число + 10) / 2:");
        for (Number num : numbers) {
            double result = (num.doubleValue() + 10) / 2;
            System.out.printf("%.2f ", result);
        }
        
        System.out.println();
        
        // BigDeccimal
        System.out.println("Числа у форматі BigDecimal:");
        for (Number num : numbers) {
            BigDecimal bigDecimal;
            if (num instanceof BigDecimal) {
            	bigDecimal = (BigDecimal) num;
            } else if (num instanceof Float || num instanceof Double) {
            	bigDecimal = BigDecimal.valueOf(num.doubleValue());
            } else {
            	bigDecimal = new BigDecimal(num.toString());
            }
            System.out.print(bigDecimal + " ");
        }
	}
}
