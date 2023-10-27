package calculator

import java.util.*

class StringCalculatorCounter() {
    private fun validateNumber(element : String){
        if (!element.matches(Regex("^\\d+$"))){
            throw IllegalArgumentException("Please Check the Input")
        }
    }

    private fun validateSymbol(element: String){
        if (!element.matches(Regex("^[+/\\-*]+$"))){
            throw IllegalArgumentException("Please Check the Input")
        }
    }

    fun calculate(input: String): Double {
        val formula = input.split(" ")
        val basicOperationsCalculator = BasicOperationsCalculator()
        val queue: Queue<String> = LinkedList(formula)
        validateNumber(queue.peek())
        var curNum = queue.poll().toDouble()

        while (queue.isNotEmpty()) {
            validateSymbol(queue.peek())
            val symbol = queue.poll()
            validateNumber(queue.peek())
            val num = queue.poll().toDouble()
            curNum = basicOperationsCalculator.operation(curNum, num, symbol)
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