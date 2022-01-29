public class Word {
    public static void main(String[] args) {
        Person person = new Person();
        Thread t1 = new Thread(person);
        t1.start();
        Person friend = new Person();
        Thread t2 = new Thread(friend);
        t2.start();
    }
}

class Person implements Runnable{
    private volatile boolean isCansel = true;
    Thread current = Thread.currentThread();
    @Override
    public void run() {
        int bird = 1;
        System.out.println(bird);
        while(!current.isInterrupted()){
            System.out.println(bird);

            if(bird%10==0){
                current.interrupt();
//                bird++;
            }

            bird++;
        }
    }
}