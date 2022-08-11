package JavaBasic;

public class Topic_11_Array_Exercise {
    int maxNumber[] = {2, 7, 6, 8, 9};

    public static void main(String[] args) {
        int a = 0;
        for (int i = 0; i < maxNumber.length; i++) {
            if (a < maxNumber[i]){
                a = maxNumber[i];
            }

            }
        System.out.println("max is :" + a);

    }
}
