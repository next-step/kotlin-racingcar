package calculator

import calculator.operation.ArithmeticOperations

class Calculator {

    fun calculate(input: String?): Int {
        val splitArray = checkEmptyString(input).split(" ")
        checkSplitArrayCount(splitArray)

        val operationList = calculateOperationList(splitArray)
        val numberList = calculateNumberList(splitArray)

        var result = numberList[0]

        for (i in 1 until numberList.size) {
            val operation = operationList[i - 1]
            result = operation.operation(result, numberList[i])
        }

        return result
    }

    fun checkEmptyString(input: String?): String {
        require(!input.isNullOrBlank()) { "입력값이 null 이거나 빈 공백 문자" }
        return input
    }

    fun checkSplitArrayCount(split: List<String>) {
        checkSplit(split.size >= 3) { "문자열에 숫자나 연산자 개수 부족" }
        checkSplit(split.size % 2 != 0) { "문자열에 숫자나 연산자 개수 부족" }
    }

    fun calculateOperationList(splitArray: List<String>): List<ArithmeticOperations> = ArrayList<ArithmeticOperations>().apply {
        splitArray.forEachIndexed { index, str ->
            if (index % 2 != 0) {
                try {
                    val operatorType = OperatorType.commandOfType(str)
                    add(operatorType.operator)
                } catch (e: NoSuchElementException) {
                    throw IllegalArgumentException("operator not found")
                }
            }
        }
    }

    fun calculateNumberList(splitArray: List<String>): List<Int> = ArrayList<Int>().apply {
        splitArray.forEachIndexed { index, str ->
            if (index % 2 == 0) {
                try {
                    add(str.toInt())
                } catch (e: NumberFormatException) {
                    throw IllegalArgumentException("숫자(정수)가 아님")
                }
            }
        }
    }

    private inline fun checkSplit(value: Boolean, lazyMessage: () -> Any) {
        if (!value) {
            val message = lazyMessage()
            throw StringSplitCountInvalidException(message.toString())
        }
    }
}
