package string

import enum.IntArithmetics
object Calculator {
    private const val SPACE = " "
    private const val EMPTY_STRING = ""

    fun calculate(input: String): Int {
        validate(input)
        val inputArray: List<String> = convertToArrayList(input)

        var op = ""
        var result: Int = inputArray[0].toInt()
        for (index in 1 until inputArray.size) {
            if (index % 2 == 1) {
                op = inputArray[index]
                continue
            }

            result = arithmeticCalculate(result, op, inputArray[index].toInt())
        }

        return result
    }

    private fun convertToArrayList(input: String): ArrayList<String> {
        val inputs = input.replace(SPACE, EMPTY_STRING).toCharArray().map { it.toString() }.toTypedArray()
        return parse(inputs)
    }

    private fun parse(input: Array<String>): ArrayList<String> {
        val result = arrayListOf<String>()
        var accumulateString = ""

        for (i: Int in input.indices) {
            validateEach(input[i])

            if (IntArithmetics.containOperator(input[i])) {
                result.add(accumulateString)
                result.add(input[i])
                accumulateString = ""
                continue
            }

            accumulateString += input[i]
        }
        result.add(accumulateString)

        return result
    }

    private fun arithmeticCalculate(leftValue: Int, op: String, rightValue: Int): Int {
        val intArithmetics = IntArithmetics.matchOperator(op) ?: throw IllegalArgumentException("정의되지 않은 연산자입니다")
        return intArithmetics.apply(leftValue, rightValue)
    }

    private fun validate(input: String) {
        validateEmptyInput(input)
        validateBothEnds(input)
    }

    private fun validateEmptyInput(input: String) {
        if (input.isBlank()) {
            throw IllegalArgumentException("입력값이 비어있습니다")
        }
    }

    private fun validateBothEnds(input: String) {
        if (!input[0].isDigit() || !input[input.length - 1].isDigit()) {
            throw IllegalArgumentException("잘못된 수식입니다")
        }
    }

    private fun validateEach(value: String) {
        if (isDigit(value) || IntArithmetics.containOperator(value)) {
            return
        }

        throw IllegalArgumentException("숫자 혹은 유효한 연산자가 아닙니다")
    }

    private fun isDigit(value: String): Boolean {
        return value.toIntOrNull() != null
    }
}
