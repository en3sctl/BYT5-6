package Group2;

//abstract class with the template method
abstract class AlgorithmTemplate {
    //template method defines the algorithm
    public void execute(){
        step1();
        step2();
        step3();
        additionalStep();
    }

    //steps to be implemented by concrete classes
    protected abstract void step1();
    protected abstract void step2();
    protected abstract void step3();

    //additional step with a default implementation
    protected void additionalStep(){
        System.out.println("Default additional step");
    }
}

class ConcreteAlgorithm1 extends AlgorithmTemplate {
    @Override
    protected void step1() {
        System.out.println("ConcreteAlgorithm1 - Step1");
    }

    @Override
    protected void step2() {
        System.out.println("ConcreteAlgorithm1 - Step2");
    }

    @Override
    protected void step3() {
        System.out.println("ConcreteAlgorithm1 - Step3");
    }

    //overriding the additional step
    @Override
    protected void additionalStep() {
        System.out.println("ConcreteAlgorithm1 - Custom Additional step");
    }
}

//another concrete class with different implementation
class ConcreteAlgorithm2 extends AlgorithmTemplate {
    @Override
    protected void step1() {
        System.out.println("ConcreteAlgorithm2 - Step1");
    }

    @Override
    protected void step2() {
        System.out.println("ConcreteAlgorithm2 - Step2");
    }

    @Override
    protected void step3() {
        System.out.println("ConcreteAlgorithm2 - Step3");
    }

    public static void main(String[] args) {
        //using the first concrete implementation
        ConcreteAlgorithm1 algorithm1 = new ConcreteAlgorithm1();
        algorithm1.execute();

        System.out.println("\n-------------------------------\n");

        //using the second concrete implementation
        ConcreteAlgorithm2 algorithm2 = new ConcreteAlgorithm2();
        algorithm2.execute();
    }
}


