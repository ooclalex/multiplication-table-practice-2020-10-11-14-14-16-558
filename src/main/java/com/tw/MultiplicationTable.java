package com.tw;

public class MultiplicationTable {
    public String create(int startNumber, int endNumber) {
        boolean isStartSmallerThanEnd = isStartSmallerThanEnd(startNumber, endNumber);
        boolean areStartAndEndInRange = areStartAndEndInRange(startNumber, endNumber);
        if (!isStartSmallerThanEnd || !areStartAndEndInRange) return null;

        return generateTable(startNumber, endNumber);
    }

    private boolean areStartAndEndInRange(int startNumber, int endNumber) {
        return 1 <= startNumber && startNumber <= 1000 &&
                1 <= endNumber && endNumber <= 1000;
    }

    private boolean isStartSmallerThanEnd(int startNumber, int endNumber) {
        return startNumber <= endNumber;
    }

    private String generateExpression(int multiplier, int multiplicand) {
        String product = multiplier + "*" + multiplicand + "=" + multiplier*multiplicand;
        if (multiplier != multiplicand) {
            product += "  ";
        }
        return product;
    }

    private String generateLine(int multiplier, int row) {
        StringBuilder strB = new StringBuilder();
        while (multiplier <= row) {
            strB.append(generateExpression(multiplier, row));
            multiplier++;
        }
        return strB.toString();
    }

    private String generateTable(int start, int end) {
        StringBuilder strB = new StringBuilder();
        int row = start;
        while (start <= end) {
            strB.append(generateLine(row, start));
            if (start != end) {
                strB.append("\r\n");
            }
            start++;
        }
        return strB.toString();
    }
}
