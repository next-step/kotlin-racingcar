package study.step2

import java.util.Arrays
import java.util.function.BiFunction

enum class Operation(
    val operation: String,
    private val operationFunction: BiFunction<Double, Double, Double>
) {
    PLUS("+", BiFunction<Double, Double, Double> { a: Double, b: Double -> a + b }),
    MINUS("-", BiFunction<Double, Double, Double> { a: Double, b: Double -> a - b }),
    MULTIPLY("*", BiFunction<Double, Double, Double> { a: Double, b: Double -> a * b }),
    DIVISION("/", BiFunction<Double, Double, Double> { a: Double, b: Double -> a / b });

    fun calculateNumbers(num1: Double, num2: Double): Double {
        return operationFunction.apply(num1, num2)
    }

    companion object {
        fun chooseOperation(operation: String?): Operation {
            return Arrays.stream(Operation.values())
                .filter { v: Operation -> v.operation == operation }
                .findAny()
                .orElseThrow { IllegalArgumentException("일치하는 연산자가 없습니다.") }
        }
    }
}
