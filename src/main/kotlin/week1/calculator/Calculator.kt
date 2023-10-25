package week1.calculator

class Calculator {

    // 계산 시 연산자의 우선순위를 고려하지 않는다.
    fun calculate(input: String?): Int {
        return 0
    }

    fun add(a: Int, b: Int): Int {
        return a + b
    }

    fun subtract(a: Int, b: Int): Int {
        return a - b
    }

    fun multiply(a: Int, b: Int): Int {
        return a * b
    }

    fun divide(a: Int, b: Int): Int {
        return a / b
    }

    fun checkInput(input: String?) {
        if (input.isNullOrBlank()) throw IllegalArgumentException()
    }

    fun checkOperatorType(candidate: String) {
        OperatorType.valueOf(candidate)
    }

}