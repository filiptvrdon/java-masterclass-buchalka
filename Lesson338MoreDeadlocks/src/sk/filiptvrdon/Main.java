package sk.filiptvrdon;

public class Main {
    public static void main(String[] args) {
        PolitePerson jane = PolitePerson.createPolitePerson("Jane");
        PolitePerson john = PolitePerson.createPolitePerson("John");

        new Thread(new Runnable() {
            @Override
            public void run() {
                jane.sayHello(john);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                john.sayHello(jane);
            }
        }).start();


    }


    static class PolitePerson{
        private String name;
        private PolitePerson(String name){
            this.name = name;
        }
        public String getName(){
            return name;
        }
        public static PolitePerson createPolitePerson(String name){
            return new PolitePerson(name);
        }

        public synchronized void sayHello(PolitePerson person){
            System.out.format("%s: %s" + " has said hello to me!%n", this.name, person.getName());
            person.sayHelloBack(this);
        }

        public synchronized void sayHelloBack(PolitePerson person){
            System.out.format("%s: %s" + " has said hello back to me!%n", this.name, person.getName());
        }
    }
}