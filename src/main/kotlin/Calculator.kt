import jdk.jshell.spi.ExecutionControl

class Calculator {
    fun calculate(input : String) : Int{
        throw ExecutionControl.NotImplementedException(Exception().stackTrace[0].methodName);
    }

    fun add(a: Int, b: Int) :Int {
        throw ExecutionControl.NotImplementedException(Exception().stackTrace[0].methodName);
    }

    fun subtract(a: Int, b: Int) :Int {
        throw ExecutionControl.NotImplementedException(Exception().stackTrace[0].methodName);
    }

    fun multiply(a: Int, b: Int) :Int {
        throw ExecutionControl.NotImplementedException(Exception().stackTrace[0].methodName);
    }

    fun divide(a: Int, b: Int) :Int {
        throw ExecutionControl.NotImplementedException(Exception().stackTrace[0].methodName);
    }
}