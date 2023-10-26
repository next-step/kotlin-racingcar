package calculator

import java.util.*

class StringCalculatorCounter(private val formula: List<String>) {

    fun calculate(): Double {
        val basicOperationsCalculator = BasicOperationsCalculator()
        val queue: Queue<String> = LinkedList(formula)
        var curNum = queue.poll().toDouble()

        while (queue.isNotEmpty()) {
            val symbol = queue.poll()
            val num = queue.poll().toDouble()
            curNum = basicOperationsCalculator.operation(curNum, num, symbol)
        }

        return curNum
    }

    constructor(input: String) : this(input.split(
        " "))
}

fun main() {
    print("수식을 입력하세요: ") // 사용자에게 메시지 출력
    val formula: String? = readLine() // 사용자 입력 받기
    val stringCalculatorCounter = StringCalculatorCounter(formula.toString())
    val result = stringCalculatorCounter.calculate()
    println("결과값: $result!") // 수식 값 출력
}