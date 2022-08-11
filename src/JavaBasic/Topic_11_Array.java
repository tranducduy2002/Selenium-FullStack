package JavaBasic;


public class Topic_11_Array {
    String name;
    int age;

    public  Topic_11_Array(String name, int age){
        this.name = name;
        this.age = age;
    }
    public void display(){
        System.out.println("Name: " + name);
        System.out.println("Name: " + age);
    }

    public static void main(String[] args){
        Topic_11_Array[] students = new Topic_11_Array[3];

        students[0] = new Topic_11_Array("Trung", 24);
        students[1] = new Topic_11_Array("Nam", 30);
        students[2] = new Topic_11_Array("Ngoc", 35);
        for (int i = 0; i < 3; i++) {
            students[i].display();
        }
    }
}

