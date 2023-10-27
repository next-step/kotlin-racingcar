package calculator

import java.util.LinkedList
import java.util.Queue

class StringCalculatorCounter() {
    private val queue: Queue<String>
    private val basicOperationsCalculator: BasicOperationsCalculator

    init {
        queue = LinkedList()
        basicOperationsCalculator = BasicOperationsCalculator()
    }

    private fun validateNumber(element: String) {
        if (!element.matches(Regex("^\\d+$"))) {
            queue.clear()
            throw IllegalArgumentException("Please Check the Input")
        }
    }

    private fun validateSymbol(element: String) {
        if (!element.matches(Regex("^[+/\\-*]+$"))) {
            queue.clear()
            throw IllegalArgumentException("Please Check the Input")
        }
    }

    private fun getSymbol(): String {
        val symbol = queue.poll()
        validateSymbol(symbol)
        return symbol
    }

    private fun getNumber(): Double {
        val number = queue.poll()
        validateNumber(number)
        return number.toDouble()
    }

    private fun basicOperation(firstNum: Double, secondNum: Double, symbol: String): Double {
        try {
            return basicOperationsCalculator.operation(firstNum, secondNum, symbol)
        } catch (e: IllegalArgumentException) {
            queue.clear()
            throw IllegalArgumentException("Please Check the Input")
        }
    }

    fun calculate(input: String): Double {
        queue.addAll(input.split(" "))
        var curNum = getNumber()

        while (queue.isNotEmpty()) {
            var symbol = getSymbol()
            var num = getNumber()
            curNum = basicOperation(curNum, num, symbol)
        }

        return curNum
    }
}

fun main() {
    print("수식을 입력하세요: ") // 사용자에게 메시지 출력
    val formula: String? = readLine() // 사용자 입력 받기
    val stringCalculatorCounter = StringCalculatorCounter()
    val result = stringCalculatorCounter.calculate(formula.toString())
    println("결과값: $result!") // 수식 값 출력
}
