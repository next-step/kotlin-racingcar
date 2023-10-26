package week1.calculator

class Calculator {

    // 계산 시 연산자의 우선순위를 고려하지 않는다.
    fun calculate(input: String?): Int {
        checkInput(input)
        checkNotNull(input)

        val numbers = mutableListOf<Int>()
        val operators = mutableListOf<OperatorType>()
        input.split(' ').forEach {
            if (it.length == 1 && !isDigit(it)) {
                operators.add(OperatorType.from(it))
            } else {
                numbers.add(it.toInt())
            }
        }

        var result = numbers.first()
        operators.forEachIndexed { idx, operatorType ->
            val a = result
            val b = numbers[idx + 1]

            result = when (operatorType) {
                OperatorType.ADD -> add(a, b)
                OperatorType.SUBTRACT -> subtract(a, b)
                OperatorType.MULTIPLY -> multiply(a, b)
                OperatorType.DIVIDE -> divide(a, b)
            }
        }

        println("식 계산 결과 = [$result]")
        return result
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

    private fun isDigit(candidate: String): Boolean {
        return digits.contains(candidate)
    }

    companion object {
        private val digits = listOf("0", "1", "2", "3", "4", "5", "6", "7", "8", "9")
    }
}