package calculator

import java.util.*

class StringCalculator private constructor(private val calculationDeque: LinkedList<String>) {
    fun calculate(): String {
        var result = ""
        while (isContinued()) {
            val operand1: String = calculationDeque.pollFirst()
            val operator: String = calculationDeque.pollFirst()
            val operand2: String = calculationDeque.pollFirst()
            result = ChunkStringCalculator.calculate(operand1, operator, operand2)
            calculationDeque.addFirst(result)
        }

        if (isValidResult()) {
            return result
        } else {
            throw IllegalArgumentException("(피)연산자 부족으로 계산에 실패했다.")
        }
    }

    private fun isContinued(): Boolean {
        return calculationDeque.size >= 3
    }

    private fun isValidResult(): Boolean {
        return calculationDeque.size == 1
    }

    companion object {
        fun create(tokenizedInputList: List<String>): StringCalculator {
            val calculationDeque = LinkedList<String>()
            calculationDeque.addAll(tokenizedInputList)
            return StringCalculator(calculationDeque)
        }
    }

}

fun main() {
    ConsolePrinter.printMsg("계산할 식을 입력해주세요.")
    val stringInput = ConsoleReader.readInput()
    val tokenizedInputList = Tokenizer.tokenize(stringInput)
    val stringCalculator = StringCalculator.create(tokenizedInputList)
    val stringOutput = stringCalculator.calculate()
    ConsolePrinter.printMsg("계산 결과는 $stringOutput 입니다.")
}
