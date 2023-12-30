package org.example;

public class Main {
    public static void main(String[] args) {


        // Створення матриці з випадковими значеннями
        Matrix randomMatrix1 = Matrix.randomMatrix(3, 5, 1, 10);

        // Виводимо рандомну матрицю
        System.out.println("Рандомно створена матриця:");
        randomMatrix1.printNumbers();

        System.out.println("Транспонована");
        //Транспонування
        Matrix ram2 = randomMatrix1.transpose();
        ram2.printNumbers();

        System.out.println("Перемножена");

        Matrix mult = Matrix.multiply(ram2,randomMatrix1);
        mult.printNumbers();



       /* // Створення незмінної матриці, яка є копією randomMatrix1
         Matrix.ImmutableMatrix immutableCopy = randomMatrix1.new ImmutableMatrix(randomMatrix1);
            // Виведення незмінної копії матриці
        System.out.println("\nImmutable Matrix Copy:");
         immutableCopy.printNumbers();

        System.out.println("============");

        Matrix mult = Matrix.multiply(randomMatrix1,randomMatrix1);
        mult.printNumbers();

        boolean res = randomMatrix1.equals(immutableCopy);
        System.out.println(res);


        //обернена матриця
        Matrix inverseMatrix = inverse(randomMatrix1);
        System.out.println("\nInverse matrix:");
        inverseMatrix.printNumbers();


        System.out.println("hashCode:");
        System.out.println(inverseMatrix.hashCode());
        System.out.println(inverseMatrix.hashCode());*/

    }





//    // Створення незмінної матриці, яка є копією randomMatrix1
//    Matrix.ImmutableMatrix immutableCopy = randomMatrix1.new ImmutableMatrix(randomMatrix1);
//
//    // Виведення незмінної копії матриці
//        System.out.println("\nImmutable Matrix Copy:");
//        immutableCopy.printNumbers();



//        Matrix randomMatrix1 = new Matrix(randomMatrix);
//
//        boolean rowValues = randomMatrix.equals(randomMatrix1);
//        System.out.println(rowValues);


        /*
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of rows for matrix: ");
        int rows = scanner.nextInt();
        System.out.print("Enter the number of columns for matrix: ");
        int columns = scanner.nextInt();

        // Створення та ініціалізація матриці
        Matrix matrix1 = new Matrix(rows, columns);
        matrix1.initializeMatrix();

        // Виведення матриці
        System.out.println("Matrix1:");
        matrix1.printNumbers();*/


        /*// Введення розмірів матриці
        System.out.print("Enter the number of rows for matrix: ");
        int rows = scanner.nextInt();
        System.out.print("Enter the number of columns for matrix: ");
        int columns = scanner.nextInt();

        // Створення та ініціалізація матриці
        Matrix matrix1 = new Matrix(rows, columns);
        matrix1.initializeMatrix();

        // Виведення матриці
        System.out.println("Matrix1:");
        matrix1.printNumbers();

       // Множення на скаляр та виведення результату
        Matrix resultMatrix = randomMatrix.multiply( 4);
        System.out.println("Матриця після множення на скаляр:");
        resultMatrix.printNumbers();

        // Введення розмірів матриці
        System.out.print("Enter the number of rows for matrix: ");
        int rows2 = scanner.nextInt();
        System.out.print("Enter the number of columns for matrix: ");
        int columns2 = scanner.nextInt();

        // Створення та ініціалізація матриці
        Matrix matrix2 = new Matrix(rows2, columns2);
        matrix2.initializeMatrix();

        // Виведення матриці
        System.out.println("Matrix2:");
        matrix2.printNumbers();

        matrix2 = Matrix.add(matrix1, matrix2);

        System.out.println("Matrix:");
        matrix2.printNumbers();

        int row = matrix1.get( 1,  1);
        System.out.println(row);


        int[] rowValues = matrix1.getRow(1); //
        // Виведення значень елементів рядка
        for (int value : rowValues) {
            System.out.print(value + " ");
         }



        int[] Values = matrix1.getColumn(1); //
        // Виведення значень елементів стовпця
        for (int value : Values) {
            System.out.print(value + " *");
        }



         Matrix matrix2 = new Matrix(matrix1);
        // Виведення матриці
        System.out.println("Matrix2:");
        matrix2.printNumbers();

        boolean res = matrix2.equals(matrix1);
        System.out.println(res);


        //Транспонування
        Matrix resultMatrix1 = randomMatrix1.transpose();
        resultMatrix1.printNumbers();


        //створення діагональної матриці на основі вектора
        Matrix mult1= Matrix.diagonalMatrix(new int[]{1,3,5}) ;
        mult1.printNumbers();



         //обернена матриця
        Matrix inverseMatrix = inverse(randomMatrix1);
        System.out.println("\nInverse matrix:");
        inverseMatrix.printNumbers();

        */

    }






