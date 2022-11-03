package calculator

class Calculator {

    fun calculate(input: String): Int {
        require(input.isNotBlank()) {
            throw IllegalArgumentException("빈 값은 올 수 없어요")
        }

        val values = input.split(" ")

        var number = values[0].toInt()
        for (i: Int in 1..values.lastIndex step 2) {
            val stringSymbol = values[i]
            val secondNum = values[i + 1].toInt()

            val operation = Operation.of(stringSymbol)
            number = operation.operate(number, secondNum)
        }

        return number
    }
}
