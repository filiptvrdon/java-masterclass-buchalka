public class Main {
    public static void main(String[] args) {
        System.out.println("Record Project");

        for (int i = 1; i <=5 ; i++){
            LPAStudent s = new LPAStudent("S92300" + i,
                    switch (i){
                case 1 -> "Mary";
                case 2 -> "Carol";
                case 3 -> "Tim";
                case 4 -> "Harry";
                case 5 -> "Lisa";
                default -> "Anonymous";
                    },
                    "05/11/1985",
                    "Java Masterclass"
                    );
            System.out.println(s);
        }

        Student pojoStudent = new Student("2923006", "Ann", "05/11/1985", "Java Masterclass");
        pojoStudent.setClassList(pojoStudent.getClassList() + ", Java OCP Exam 829");
        System.out.println(pojoStudent);
        System.out.println(pojoStudent.getName() + " is taking " + pojoStudent.getClassList());



        LPAStudent recordStudent = new LPAStudent("2923007", "Bill","05/11/1985", "Java Masterclass");
        // recordStudent.setClassList(recordStudent.getClassList() + ", Java OCP Exam 829");
        System.out.println(recordStudent);
        System.out.println(recordStudent.name() + " is taking " + recordStudent.classList());
    }
}