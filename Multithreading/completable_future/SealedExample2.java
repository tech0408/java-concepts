package completable_future;


sealed class Animal permits Cat, Dog{

}

non-sealed  class Cat extends Animal{

}

final class Dog extends Animal{

}

class Tiger extends Cat{

}

public class SealedExample2 {
}
