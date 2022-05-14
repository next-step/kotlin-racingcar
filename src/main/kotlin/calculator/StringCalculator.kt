package calculator

import calculator.enum.Operator

class StringCalculator {
    companion object {
        const val MIN_LENGTH = 3L
    }

    fun calculate(inputStr: String? = null): Long {
        val inputList = convertStrToList(inputStr)
        val inputSize = inputList.size
        require(inputSize >= MIN_LENGTH && inputSize.isOddNumber()) { "잘못된 형식의 Input 입니다." }
        return calculateStart(inputList)
    }

    private fun calculateStart(inputStr: List<String>): Long {
        val numbers = fetchNumberList(inputStr)
        val operators = fetchOperatorList(inputStr)
        var sum = numbers[0]
        for (i in operators.indices) {
            sum = CalculateInfo(sum, numbers[i + 1], operators[i]).doCalculate()
        }
        return sum
    }

    private fun fetchOperatorList(inputStrList: List<String>): List<Operator> {
        return inputStrList.filterIndexed { index, _ -> index.isOddNumber() }
            .map { opStr -> Operator.findBy(opStr) }
    }

    private fun fetchNumberList(inputStrList: List<String>): List<Long> {
        return inputStrList.filterIndexed { index, _ -> index.isEvenNumber() }
            .map { numStr ->
                requireNotNull(numStr.toLongOrNull()) { "숫자가 아니에요." }
            }
    }

    private fun convertStrToList(inputString: String? = null): List<String> {
        require(!inputString.isNullOrBlank()) { "Input이 비어있어요. 다시 시도해주세요." }
        return inputString.split(" ")
    }
}

fun Int.isEvenNumber() = this % 2 == 0
fun Int.isOddNumber() = !this.isEvenNumber()
