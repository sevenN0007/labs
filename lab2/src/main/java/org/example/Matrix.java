package org.example;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Matrix {
    private int rows;
    private int columns;
    private double[][] matrix;

    // Конструктор для створення пустої матриці
    public Matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.matrix = new double[rows][columns];
    }


    // Конструктор для створення матриці з визначеними розмірами
    public Matrix(int rows, int columns, double[][] matrix) {
        this.rows = rows;
        this.columns = columns;
        this.matrix = matrix;
    }


    // Конструктор копіювання
    public Matrix(Matrix other) {
        this.rows = other.rows;
        this.columns = other.columns;
        this.matrix = new double[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                this.matrix[i][j] = other.matrix[i][j];
            }
        }
    }

    // Ініціалізація матриці через введення користувача
    public void initializeMatrix() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter values for the matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print("Enter element at position (" + i + ", " + j + "): ");
                int value = scanner.nextInt();
                setElement(i, j, value);
            }
        }
    }

    // Функція для рандомного заповнення матриці визначеними розмірами
    public static Matrix randomMatrix(int rows, int columns, int minValue, int maxValue) {
        double[][] matrix = new double[rows][columns];
        Random random = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = random.nextInt(maxValue - minValue + 1) + minValue;
            }
        }
        return new Matrix(rows, columns, matrix);
    }


    // Отримання елемента за індексами
    public double get(int row, int column) {

        return matrix[row][column];
    }

    // Отримання рядка за індексом
    public double[] getRow(int num) {

        return matrix[num];
    }


    // Отримання кількості стовпців
    public double[] getColumn(int num) {
        double[] result = new double[rows];
        for (int i = 0; i < rows; i++) {
            result[i] = matrix[i][num];
        }
        return result;
    }

    // Метод для отримання розмірів матриці
    public int[] getDimensions() {

        return new int[]{rows, columns};
    }

    // Перевірка рівності матриць
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Matrix other = (Matrix) obj;
        if (rows != other.rows || columns != other.columns) {
            return false;
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] != other.matrix[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    // Хеш-код матриці
    @Override
    public int hashCode() {
        int result = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                long bits = Double.doubleToLongBits(matrix[i][j]);
                result = 31 * result + (int) (bits ^ (bits >>> 32));
            }
        }
        return result;
    }

    // Встановлення значення елемента за індексами
    public void setElement(int row, int column, int value) {

        matrix[row][column] = value;
    }

    // Сума матриць
    public static Matrix add(Matrix a, Matrix b) {
        Matrix result = new Matrix(a.rows, a.columns);
        for (int i = 0; i < a.rows; i++) {
            for (int j = 0; j < a.columns; j++) {
                result.matrix[i][j] = a.matrix[i][j] + b.matrix[i][j];
            }
        }
        return result;
    }


    // Перемноження матриць
    public static Matrix multiply(Matrix a, Matrix b) {
        Matrix result = new Matrix(a.rows, b.columns);
        for (int i = 0; i < a.rows; i++) {
            for (int j = 0; j < b.columns; j++) {
                int sum = 0;
                for (int k = 0; k < a.columns; k++) {
                    sum += a.matrix[i][k] * b.matrix[k][j];
                }
                result.matrix[i][j] = sum;
            }
        }
        return result;
    }


    // Множення матриці на скаляр
    public Matrix multiply(int scalar) {
        double[][] resultMatrix = new double[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                resultMatrix[i][j] = matrix[i][j] * scalar;
            }
        }
        return new Matrix(rows, columns, resultMatrix);
    }


    // Виведення чисел матриці
    public void printNumbers() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }


    // Метод для транспонування матриці
    public Matrix transpose() {
        int transposedRows = this.columns;
        int transposedColumns = this.rows;
        Matrix transposedMatrix = new Matrix(transposedRows, transposedColumns);

        for (int i = 0; i < this.rows; i++) {  // Зверніть увагу на зміну умов циклу
            for (int j = 0; j < this.columns; j++) {
                transposedMatrix.matrix[j][i] = this.matrix[i][j];
            }
        }
        return transposedMatrix;
    }

    // Метод для створення діагональної матриці на основі вектора
    public static Matrix diagonalMatrix(int[] diagonalValues) {
        int size = diagonalValues.length;
        Matrix diagonalMatrix = new Matrix(size, size);

        for (int i = 0; i < size; i++) {
            diagonalMatrix.matrix[i][i] = diagonalValues[i];
        }

        return diagonalMatrix;
    }

    // Метод для створення одиничної матриці
    public static Matrix createIdentityMatrix(int size) {
        Matrix identityMatrix = new Matrix(size, size);
        for (int i = 0; i < size; i++) {
            identityMatrix.setElement(i, i, 1);
        }
        return identityMatrix;
    }

    // Метод для створення матриці-строки з випадковими значеннями
    public static Matrix createRandomRowMatrix(int length, int minValue, int maxValue) {
        Matrix rowMatrix = new Matrix(1, length);
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            rowMatrix.setElement(0, i, random.nextInt(maxValue - minValue + 1) + minValue);
        }
        return rowMatrix;
    }

    // Метод для створення матриці-стовпчика з випадковими значеннями
    public static Matrix createRandomColumnMatrix(int length, int minValue, int maxValue) {
        Matrix columnMatrix = new Matrix(length, 1);
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            columnMatrix.setElement(i, 0, random.nextInt(maxValue - minValue + 1) + minValue);
        }
        return columnMatrix;
    }

    // Метод для перетворення матриці в нижню трикутну форму
    public void toLowerTriangular() {
        for (int i = 0; i < rows; i++) {
            for (int j = i + 1; j < columns; j++) {
                 matrix[i][j] = 0;// Заповнюємо нулями елементи вище головної діагоналі
            }
        }
    }


    // Метод для перетворення матриці в верхню трикутну форму
    public void toUpperTriangular() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < i; j++) {
                matrix[i][j] = 0; // Заповнюємо нулями елементи нижче головної діагоналі
            }
        }
    }

    //Детермінант
     private static double determinant(double[][] matrix) {
        if (matrix.length != matrix[0].length)
            throw new IllegalStateException("invalid dimensions");

        if (matrix.length == 2)
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];

        double det = 0;
        for (int i = 0; i < matrix[0].length; i++)
            det += Math.pow(-1, i) * matrix[0][i]
                    * determinant(minor(matrix, 0, i));
        return det;
    }

    // Getter method for 'matrix'
    public double[][] getMatrix() {
        return this.matrix;
    }

    // Обернена матриця
    public static Matrix inverse(Matrix matrix) {
        int rows = matrix.getDimensions()[0];
        int columns = matrix.getDimensions()[1];
        double[][] matrixData = matrix.getMatrix(); // Replace with the correct method

        double[][] inverse = new double[rows][columns];

        // minors and cofactors
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                double minorDeterminant = determinant(minor(matrixData, i, j));
                inverse[i][j] = Math.pow(-1, i + j) * minorDeterminant;
            }
        }

        // adjugate and determinant
        double det = 1.0 / determinant(matrixData);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j <= i; j++) {
                double temp = inverse[i][j];
                inverse[i][j] = inverse[j][i] * det;
                inverse[j][i] = temp * det;
            }
        }

        return new Matrix(rows, columns, inverse);
    }


    private static double[][] minor(double[][] matrix, int row, int column) {
        double[][] minor = new double[matrix.length - 1][matrix.length - 1];

        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; i != row && j < matrix[i].length; j++)
                if (j != column)
                    minor[i < row ? i : i - 1][j < column ? j : j - 1] = matrix[i][j];
        return minor;
    }

    public final class ImmutableMatrix {
        private final int rows;
        private final int columns;
        private final double[][] matrix;

        public ImmutableMatrix(int rows, int columns, double[][] matrix) {
            this.rows = rows;
            this.columns = columns;
            this.matrix = Arrays.copyOf(matrix, matrix.length);
            for (int i = 0; i < matrix.length; i++) {
                this.matrix[i] = Arrays.copyOf(matrix[i], matrix[i].length);
            }
        }

        public ImmutableMatrix(Matrix matrix) {
            this.rows = matrix.getDimensions()[0];
            this.columns = matrix.getDimensions()[1];
            this.matrix = new double[rows][columns];

            for (int i = 0; i < rows; i++) {
                System.arraycopy(matrix.getMatrix()[i], 0, this.matrix[i], 0, columns);
            }
        }

        public ImmutableMatrix(ImmutableMatrix other) {
            this.rows = other.rows;
            this.columns = other.columns;
            this.matrix = new double[rows][columns];

            for (int i = 0; i < rows; i++) {
                System.arraycopy(other.matrix[i], 0, this.matrix[i], 0, columns);
            }
        }

        public double get(int row, int column) {
            return matrix[row][column];
        }

        public double[] getRow(int num) {
            return matrix[num];
        }

        public double[] getColumn(int num) {
            double[] result = new double[rows];
            for (int i = 0; i < rows; i++) {
                result[i] = matrix[i][num];
            }
            return result;
        }

        public int[] getDimensions() {
            return new int[]{rows, columns};
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            ImmutableMatrix other = (ImmutableMatrix) obj;
            if (rows != other.rows || columns != other.columns) {
                return false;
            }
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    if (matrix[i][j] != other.matrix[i][j]) {
                        return false;
                    }
                }
            }
            return true;
        }

        @Override
        public int hashCode() {
            int result = 1;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    result = 31 * result + Double.hashCode(matrix[i][j]);
                }
            }
            return result;
        }

        public ImmutableMatrix add(Matrix a, Matrix b) {
            double[][] resultMatrix = new double[a.getDimensions()[0]][a.getDimensions()[1]];
            for (int i = 0; i < a.getDimensions()[0]; i++) {
                for (int j = 0; j < a.getDimensions()[1]; j++) {
                    resultMatrix[i][j] = a.get(i, j) + b.get(i, j);
                }
            }
            return new ImmutableMatrix(a.getDimensions()[0], a.getDimensions()[1], resultMatrix);
        }

        public ImmutableMatrix multiply(Matrix a, Matrix b) {
            double[][] resultMatrix = new double[a.getDimensions()[0]][b.getDimensions()[1]];
            for (int i = 0; i < a.getDimensions()[0]; i++) {
                for (int j = 0; j < b.getDimensions()[1]; j++) {
                    double sum = 0;
                    for (int k = 0; k < a.getDimensions()[1]; k++) {
                        sum += a.get(i, k) * b.get(k, j);
                    }
                    resultMatrix[i][j] = sum;
                }
            }
            return new ImmutableMatrix(a.getDimensions()[0], b.getDimensions()[1], resultMatrix);
        }

        public ImmutableMatrix multiply(int scalar) {
            double[][] resultMatrix = new double[this.rows][this.columns];
            for (int i = 0; i < this.rows; i++) {
                for (int j = 0; j < this.columns; j++) {
                    resultMatrix[i][j] = this.matrix[i][j] * scalar;
                }
            }
            return new ImmutableMatrix(this.rows, this.columns, resultMatrix);
        }

        public void printNumbers() {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}


