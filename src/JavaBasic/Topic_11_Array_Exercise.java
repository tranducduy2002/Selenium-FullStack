package JavaBasic;

import org.testng.annotations.Test;

public class Topic_11_Array_Exercise {
    static int[] maxNumber = {2, 7, 6, 8, 9};

   /* public static void main(String[] args) {

        int a = 0;
        for (int i = 0; i < maxNumber.length; i++) {
            if (a < maxNumber[i]) {
                a = maxNumber[i];
            }

        }
        System.out.println("max is :" + a);
    }*/
     // @Test
    public void TC_02_Exercise() {
        System.out.println("Tổng số đầu và cuối: " + (maxNumber[0] + maxNumber[maxNumber.length - 1]));

        }

        //@Test
    public void TC_03_Exercise(){
          int arrayNumber[] = {2, 6, 7, 11, 5, 8, 13};
          int x = 0;
            for (int i = 0; i < arrayNumber.length; i++) {
                if (arrayNumber[i]%2 == 0){
                    x += arrayNumber[i];
                }
            }
            System.out.println(x);

        }

       // @Test
    public void TC_04_Excerise(){
            int arrayNumberTwo[] = {2, 6, -7, 11, 5, 8, -13};
            int y = 0;
            for (int i = 0; i < arrayNumberTwo.length; i++) {
                if (arrayNumberTwo[i] > 0) {
                    y += arrayNumberTwo[i];

                }
            } System.out.println(y);
        }

        @Test
        public void TC_05_Excerise(){
            int arrayNumberThree[] = {2, 6, -7, 11, 5, 10, -13};
            int sum = 0;
            for (int i = 0; i < arrayNumberThree.length; i++) {
                sum += arrayNumberThree[i];
            }
            System.out.println(sum);
            float sumAverage = sum / (arrayNumberThree.length);
            System.out.println(sumAverage);
        }
}