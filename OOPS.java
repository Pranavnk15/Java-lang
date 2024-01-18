public class OOPS {
    public static void main(String args[]) {
        // Pen p1 = new Pen(); //created an object for the class pen.
        // p1.setColor("Blue");//call the function of class Pen
        // //using the Dot opeartor
        // System.out.println(p1.getColor());
        // p1.setTip(5);
        // System.out.println(p1.getTip());
        // p1.setColor("Yelloe");
        // System.out.println(p1.getColor()); //we can also directly set the color

        // BankAc myAcc = new BankAc();
        // myAcc.userName = "PranavKhandagale";//as public we can access it
        // myAcc.password = "aniiad";//as defined private we cannot access it.
        // myAcc.setPassword("jhiufwdif");//We can set the new pwd but again
        // //cannot acess it as it is defined private

    //     Student s1 = new Student(); //calling non-parameterised constructor
    //     Student s2 = new Student("pranav");//calling parameterised constructor
    //     Student s3 = new Student(13);//calling parameterised constructor
    //    // Student s4 = new Student("aman", 324);//will give an error as no such function is present
            

            // Student s1 = new Student();
            // s1.name = "pranav";
            // s1.roll = 23;
            // s1.password = "abcd";
            // s1.marks[0] = 100;
            // s1.marks[1] = 90;
            // s1.marks[2] = 80;

            // Student s2 = new Student(s1); // passing object1 copying 
            // //properties of object1
            // s2.password = "xyz";
            // s1.marks[2] = 100; //It is also reflected in s2 as the marks
            // //in s2 point to s1 by reference hence it'll show updated marks

            // for(int i = 0; i<=2; i++) {
            //     System.out.println(s2.marks[i]);
            // }

            // Fish shark = new Fish();
            // shark.eat();

            // Dog dobby = new Dog();
            // dobby.eat();
            // dobby.legs = 4;
            // System.out.println(dobby.legs);

            // Calculator cal = new Calculator();
            // System.out.println(cal.sum(1, 2));
            // System.out.println(cal.sum((float)1.2, (float)2.2));
            // System.out.println(cal.sum(1, 2 , 3));

            // Deer d = new Deer();
            // d.eat();

            // Horse h = new Horse();
            // h.eat();
            // h.walk();
            // Chiken c = new Chiken();
            // c.eat();
            // c.walk();
            // Animals a = new Animals();

            // Queen q = new Queen();
            // q.moves();
                
            Student s1 = new Student();
            s1.schoolName = "JMV";
            Student s2 = new Student();
            System.out.println(s2.schoolName);
            


    }
    
}

class Student {
    String name;
    int roll;

    static String schoolName;

    void setName(String name) {
        this.name = name;
    }
    String getName() {
        return this.name;
    }
}

interface ChessPlayer {
    void moves();
}
class Queen implements ChessPlayer {
    public void moves() {
        System.out.println("up, down, left,right, and in all 4 directions");
    }
}
class Rook implements ChessPlayer {
    public void moves() {
        System.out.println("up, down, left,right");
    }
}
class King implements ChessPlayer {
    public void moves() {
        System.out.println("up, down, left,right");
    }
}

abstract class Animals {
    void eat() {
        System.out.println("animal eats");
    }
    abstract void walk();
}
class Horse extends Animals {
    void walk() {
        System.out.println("Walks on 4 legs");
    }
}
class Chiken extends Animals {
    void walk() {
        System.out.println("walks of 2 legs");
    }
}

class Animal {
    void eat() {
        System.out.println("eats anything");
    }
}
class Deer extends Animal {
    void eat() {
        System.out.println("eats grass");
    }
}

class Calculator {
    int sum(int a, int b) {
        return a+b;
    }
    float sum(float a, float b) {
        return a+b;
    }
    int sum(int a, int b, int c) {
        return a+b+c;
    }
}

//Base class
// class Animal {
//     String color;

//     void eat() {
//         System.out.println("eats");
//     }

//     void breathe() {
//         System.out.println("breathes");
//     }

// }

//inheritance
class Mammal extends Animal {
    int legs;
}
//derived class1
class Dog extends Mammal {
    String breed;
}
//derived class2
//Derived class
class Fish extends Animal {
    int fins;

    void swim() {
        System.out.println("Swims in water");
    }
}

// class Student {
//     String name;
//     int roll;
//     String password;
//     int marks[];

//     //shallow copy constructor
//     // Student(Student s1) {
//     //     //creating a copy constructor
//     //     marks = new int[3];
//     //     this.name = s1.name;
//     //     this.roll = s1.roll;
//     //     this.marks = s1.marks;
//     // }

//     //deep copy constructor
//     Student(Student s1) {
//         marks = new int[3];
//         this.name = s1.name;
//         this.roll = s1.roll;
//         for(int i =0; i<marks.length;i++) {
//             this.marks[i] = s1.marks[i];
//         }

//     }

//     Student() {//non-parametrise constructor
//         marks = new int[3];
//         System.out.println("Constructor is called");
//     }
//     Student(String name) { //parametrised constructor
//         marks = new int[3];
//         this.name = name;
//     }
//     Student(int roll) {//parametrised constructor
//         marks = new int[3];
//         this.roll = roll;
//     }
// }

// // class BankAc {
// //     public String userName; //defined with public-accessible to all
// //     private String password;//defined with private-only accessible
// //     //within the class and not outside the class.
// //     public void setPassword(String pwd) {
// //         password = pwd;
// //     }
// // } 

public class Pen {
    //properties + functions of class are defined here
    private String color;
    private int tip;

    String getColor() {
        return this.color;
    }

    int getTip() {
        return this.tip;
    }
    void setColor(String newColor) {
        this.color = newColor;
    }

    void setTip(int newTip) {
        this.tip = newTip;
    }


}
