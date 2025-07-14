class VolatileEx {

    private boolean flag = false;

    public void setFlag(){
        flag = true;
    }

    public boolean getFlag(){
        return flag;
    }
}


public class VolatileExample {

    public static void main(String[] args) {

        VolatileEx vex = new VolatileEx();

        // Writer Thread.
        new Thread(()->{

            System.out.println("Writer thread is setting the value");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            vex.setFlag();
        }).start();


        // Reader thread.
        new Thread(()->{

            System.out.println("Reader thread is checking for flag change");
            while(!vex.getFlag()) {}
            System.out.println("Flag change is detected");

        }).start();

    }
}
