package string
import enum.IntArithmetics

fun main() {
    println(Calculator.calculate("2+4*3"))
}
object Calculator {
    fun calculate(input: String): Int {
        validate(input)
        val inputArray: Array<String> = convertToArray(input)

        var op = ""
        var result: Int = inputArray[0].toInt()
        for (index in 1 until inputArray.size) {
            if (index % 2 == 1) {
                op = inputArray[index]
                continue
            }

            validateIsDigit(inputArray[index])
            result = calc(result, op, inputArray[index].toInt())
        }

        return result
    }

    private fun convertToArray(input: String): Array<String> {
        return input.replace(" ", "").toCharArray().map { it.toString() }.toTypedArray()
    }

    private fun parse(input: Array<String>) {
        val result = emptyArray<String>()
        var numbericString: String = ""

        for(i: Int in 0..input.size) {

            numbericString += input[i]
        }

    }

    private fun calc(leftValue: Int, op: String, rightValue: Int): Int {
        return when (op) {
            IntArithmetics.PLUS.operator -> {
                IntArithmetics.PLUS.apply(leftValue, rightValue)
            }
            IntArithmetics.MINUS.operator -> {
                IntArithmetics.MINUS.apply(leftValue, rightValue)
            }
            IntArithmetics.MULTIPLE.operator -> {
                IntArithmetics.MULTIPLE.apply(leftValue, rightValue)
            }
            IntArithmetics.DIVIDE.operator -> {
                IntArithmetics.DIVIDE.apply(leftValue, rightValue)
            }
            else -> throw IllegalArgumentException("정의되지 않은 연산자입니다")
        }
    }

    private fun validate(input: String) {
        validateEmptyInput(input)
    }

    private fun validateEmptyInput(input: String) {
        if (input.isBlank()) {
            throw IllegalArgumentException("입력값이 비어있습니다")
        }
    }

    private fun validateInputLength(input: String) {
        if (input.length % 2 == 0) {
            throw IllegalArgumentException()
        }
    }

    private fun validateIsDigit(value: String) {
        // value.int
        if (value.toIntOrNull() == null) {
            throw IllegalArgumentException("숫자가 아닌 입력값이 들어왔습니다")
        }
    }
}
