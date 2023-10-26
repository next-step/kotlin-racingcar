package study.step2

import java.util.LinkedList
import java.util.Queue
import java.util.regex.Pattern

class Expression(
    private val inputExpression: String
) {

    fun getNumbersFromExpression(): List<Double> = Pattern.compile("[+\\-*/]")
        .split(inputExpression)
        .map {
            it.toDouble()
        }

    fun getSpecialCharactersFromExpression(): List<String> = inputExpression.filter {
        !it.isDigit()
    }.map {
        it.toString()
    }.toList()

    fun processExpression(): Double {
        val numbers: Queue<Double> = LinkedList(getNumbersFromExpression())
        val specialCharacters: Queue<String> = LinkedList(getSpecialCharactersFromExpression())

        if (isEmptyNumberOrSpecialCharacters(numbers, specialCharacters)) {
            throw IllegalArgumentException("정상적인 수식을 입력해 주세요.")
        }

        var currentTotalValue = numbers.poll()

        do {
            val chooseOperaltor = specialCharacters.poll()
            val getNextNumber = numbers.poll()

            currentTotalValue = Operation.chooseOperation(chooseOperaltor)
                .calculateNumbers(currentTotalValue, getNextNumber)
        } while (checkBothQueuesNotEmpty(numbers, specialCharacters))

        return currentTotalValue
    }

    private fun isEmptyNumberOrSpecialCharacters(
        numbers: Queue<Double>,
        specialCharacters: Queue<String>
    ) = numbers.isEmpty() || specialCharacters.isEmpty()

    private fun checkBothQueuesNotEmpty(numbers: Queue<Double>, operators: Queue<String>) =
        numbers.isNotEmpty() && operators.isNotEmpty()
}
