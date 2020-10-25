package facade;

public class RequestFacade {

}


class Facade {
    SubSystem1 subSystem1 = new SubSystem1();
    SubSystem2 subSystem2 = new SubSystem2();
    SubSystem3 subSystem3 = new SubSystem3();

    public void doSomethingFacade() {
        subSystem1.method1();
        subSystem2.method2();
        subSystem3.method3();
    }
}

class client1 {
    Facade facade = new Facade();
    public void dosome() {
        facade.doSomethingFacade();
    }
}

class client2 {
    Facade facade = new Facade();
    public void dosome2() {
        facade.doSomethingFacade();
    }
}

class SubSystem1 {
    public void method1() {
        System.out.println("SubSystem1.method1");
    }
}

class SubSystem2 {
    public void method2() {
        System.out.println("SubSystem2.method2");
    }
}

class SubSystem3 {
    public void method3() {
        System.out.println("SubSystem3.method3");
    }
}

