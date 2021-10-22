package StringCalculator

import jdk.jshell.spi.ExecutionControl

class Calculator {
    fun calculate(input : String?) : Int{
        if (input == null) throw IllegalArgumentException()
        if (input.isBlank()) throw IllegalArgumentException()
        val array = input.split(" ");
        array.forEach { parameter ->
            if (parameter.toIntOrNull() != null) return@forEach
            if (isValidOperator(parameter)) return@forEach
            throw IllegalArgumentException()
        }
        throw ExecutionControl.NotImplementedException(Exception().stackTrace[0].methodName);
    }

    private fun isValidOperator(operation: String?) : Boolean{
        if (operation == "+") return true
        if (operation == "-") return true
        if (operation == "*") return true
        if (operation == "/") return true
        return false
    }

    fun add(a: Int, b: Int) :Int = a + b

    fun subtract(a: Int, b: Int) = a - b

    fun multiply(a: Int, b: Int) = a * b

    fun divide(a: Int, b: Int) = a / b
}