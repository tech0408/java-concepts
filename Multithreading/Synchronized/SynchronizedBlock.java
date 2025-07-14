package Multithreading.Synchronized;

/*
 * Synchronized block offers synchronization at a more granular level.
 * Instead of using synchronized method, we can go for synchronized when 
 * the code containing critical section is small when compared to the full body of method.
 * 
 * synchronized(this){} -> object level lock for the thread operating on current object.
 * synchronized(t) {} -> synchronization on the target object. (Object level lock)
 * synchronized(Class.class) {} -> class level lock.
 * 
 * 
 * Case 1: When a thread is executing synchronized block on current object and another thread
 *         wants to execute the same block, then the later thread has to wait for the object 
 *         lock to be released by previous thread.
 * 
 * Case 2: When a thread is executing sync block on current object and another thread wants to execute 
 *         the same block on different object, then both can execute simultaneously.
 * 
 * Case 3: When a thread executes sync class level block on one object and another thread
 *         executes the same block on another object, then the later thread also has to wait.
 * 
 */
class Display11{
    public void show(String name){
        synchronized(Display11.class){
            for(int i=1;i<=10;i++){
                System.out.println("Hello : "+ name);
            }
        }
    }
}

class MineThread44 extends Thread{

    private Display11 d;
    private String name;
    MineThread44(Display11 d, String name){
        this.d=d;
        this.name=name;
    }

    public void run(){
        d.show(name);
    }

}
public class SynchronizedBlock {

    public static void main(String[] args) {

        Display11 d1 = new Display11();
        Display11 d2 = new Display11();
        MineThread44 mt1 = new MineThread44(d1, "Sawan");
        MineThread44 mt2 = new MineThread44(d2, "Rishika");
        mt1.start();
        mt2.start();    
    }
    
}
