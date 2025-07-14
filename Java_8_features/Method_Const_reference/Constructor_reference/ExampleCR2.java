package Method_Const_reference.Constructor_reference;

class SampleExam{

    int id;
    String name;
    double marks;

    SampleExam(int id, String name, double marks){
        this.id=id;
        this.name=name;
        this.marks=marks;
        System.out.println("Const called :-  "+ id+":"+name+":"+marks );
    }
}

@FunctionalInterface
interface SampleInterf{

    public SampleExam get(int a, String s, double b);
}

public class ExampleCR2 {

    public static void main(String[] args) {
        

        //SampleInterf s = (a,str,b)-> new SampleExam(a,str,b); // lambda expression.
        SampleInterf s = SampleExam:: new;
        s.get(10,"Sawan",100.0);

    }
    
}
