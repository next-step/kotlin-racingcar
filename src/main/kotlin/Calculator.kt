import jdk.jshell.spi.ExecutionControl

class Calculator {
    fun calculate(input : String) : Int{
        throw ExecutionControl.NotImplementedException(Exception().stackTrace[0].methodName);
    }

    fun add(a: Int, b: Int) :Int = a + b

    fun subtract(a: Int, b: Int) = a - b

    fun multiply(a: Int, b: Int) = a * b

    fun divide(a: Int, b: Int) = a / b
}