package JavaBasic;

import org.testng.annotations.Test;

public class Topic_12_Exercise {
    String upperCase = "Automation FC";

    public void TC_01 (){
        int count = 0;
        char convertToChar[] = upperCase.toCharArray();
        for (char c : convertToChar) {
            if (c <= 'Z' && c >= 'A'){
                count++;
            }
        }
        System.out.println(count);
    }

    public void TC_02 (){
        String longString = "Automation Testing 345 Online Tutorials 789";
        char charString[] = longString.toCharArray();
        int count1 = 0;
        for (char c : charString){
            if (c == 'a'){
                count1++;
            }
        }
        System.out.println(count1);

        System.out.println(longString.contains("Testing"));
        System.out.println(longString.startsWith("Automation"));
        System.out.println(longString.endsWith("Online"));
        System.out.println(longString.endsWith("Online"));
        System.out.println(longString.indexOf("Tutorials"));
        System.out.println(longString.replace("Online", "Offline"));

        int countNumber = 0;
        int countUpperCase = 0;
        int countLowerCase = 0;
        for (char d : charString){
            if (d <= '9' && d >= '0'){
                countNumber++;
            }

            if (d <= 'Z' && d >= 'A'){
                countUpperCase++;
            }

            if (d <= 'z' && d >= 'a'){
                countLowerCase++;
            }
        }
        System.out.println(countNumber);
        System.out.println(countUpperCase);
        System.out.println(countLowerCase);
    }

    @Test
    public void TC_03 (){
        char courseNameArr[] = upperCase.toCharArray();

        for (int i = courseNameArr.length - 1; i >= 0; i--) {
            System.out.println(courseNameArr[i]);

        }
    }
    }
