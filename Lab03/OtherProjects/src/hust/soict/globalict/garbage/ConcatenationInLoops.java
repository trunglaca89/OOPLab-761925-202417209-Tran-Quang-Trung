package hust.soict.globalict.garbage;

import java.util.Random;

public class ConcatenationInLoops {
    public static void main(String[] args) {
        Random r = new Random(123);
        long start = System.currentTimeMillis();
        String s = "";
        
        // 1. Cộng chuỗi bằng toán tử "+" 
        for (int i = 0; i < 65536; i++) {
            s += r.nextInt(2);
        }
        System.out.println("Processing time using + operator: " + (System.currentTimeMillis() - start) + " ms");

        // 2. Cộng chuỗi bằng StringBuffer 
        r = new Random(123);
        start = System.currentTimeMillis();
        StringBuffer sbBuffer = new StringBuffer();
        for (int i = 0; i < 65536; i++) {
            sbBuffer.append(r.nextInt(2));
        }
        s = sbBuffer.toString();
        System.out.println("Processing time using StringBuffer: " + (System.currentTimeMillis() - start) + " ms");

        // 3. Cộng chuỗi bằng StringBuilder
        r = new Random(123);
        start = System.currentTimeMillis();
        StringBuilder sbBuilder = new StringBuilder();
        for (int i = 0; i < 65536; i++) {
            sbBuilder.append(r.nextInt(2));
        }
        s = sbBuilder.toString();
        System.out.println("Processing time using StringBuilder: " + (System.currentTimeMillis() - start) + " ms");
    }
}