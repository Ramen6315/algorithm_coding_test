package recursive;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.Scanner;

public class PascalTriangle {
    public  void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String coordinate = scanner.nextLine();
        String[] cartesianCoordinate = coordinate.split(" ");
        int x = Integer.parseInt(cartesianCoordinate[0]);
        int y = Integer.parseInt(cartesianCoordinate[1]);

        BigDecimal[][] pascalTriangles = new BigDecimal[x][y];
        initTriangle(pascalTriangles);

        BigDecimal result = find(pascalTriangles, x - 1, y - 1);
        BigDecimal answer = result.remainder(BigDecimal.valueOf(100000000));
        System.out.println(answer.intValue());

    }

    private  BigDecimal find(BigDecimal[][] pascalTriangles, int x, int y) {
        if(pascalTriangles[x][y] != null && !Objects.equals(pascalTriangles[x][y], BigDecimal.valueOf(1))) {
            return pascalTriangles[x][y];
        }
        if(x == 0) {
            return BigDecimal.valueOf(1L);
        } else if(y == 0) {
            return BigDecimal.valueOf(1L);
        }
        BigDecimal result = find(pascalTriangles, x - 1, y).add(find(pascalTriangles, x, y - 1));
        pascalTriangles[x][y] = result;
        return result;
    }

    private  void initTriangle(BigDecimal[][] pascalTriangles) {
        for (int i = 0; i < pascalTriangles.length; i++) {
            pascalTriangles[i][0] = BigDecimal.valueOf(1);
        }
        for (int i = 0; i < pascalTriangles[0].length; i++) {
            pascalTriangles[0][i] = BigDecimal.valueOf(1);
        }
    }
}
