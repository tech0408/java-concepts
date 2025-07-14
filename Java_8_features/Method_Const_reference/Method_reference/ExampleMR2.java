package Method_Const_reference.Method_reference;

/*
 * for method reference, only the parameters of method which is to be used for SAM inside FI
 * should match. Return types, modifiers and name can be different.
 */

interface MRInterf{
    public void add(int a, int b);
}

public class ExampleMR2 {

    // Here only the parameters are matching and name,return type and modifiers are different.
    // Still we can use this to refer to add() of MRInterf.
    private int addNums(int a, int b){

        System.out.println("Addsum method called: " + (a+b));
        return 4;

    }

    public static void main(String[] args) {

        ExampleMR2 mr2 = new ExampleMR2();
        MRInterf mri = mr2::addNums; // using method reference -> this does not automatically calls it.
        mri.add(12, 16);
        mri.add(45,34);   
    }
    
}
