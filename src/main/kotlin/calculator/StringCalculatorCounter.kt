package calculator

class StringCalculatorCounter() {
    private val mutableList: MutableList<String>
    private val basicOperationsCalculator: BasicOperationsCalculator

    init {
        mutableList = mutableListOf()
        basicOperationsCalculator = BasicOperationsCalculator()
    }

    private fun validateNumber(element: String) {
        if (!element.matches(Regex("^\\d+$"))) {
            mutableList.clear()
            throw IllegalArgumentException("Please Check the Input")
        }
    }

    private fun validateSymbol(element: String) {
        if (!element.matches(Regex("^[+/\\-*]+$"))) {
            mutableList.clear()
            throw IllegalArgumentException("Please Check the Input")
        }
    }

    private fun getSymbol(): String {
        val symbol = mutableList.removeAt(0)
        validateSymbol(symbol)
        return symbol
    }

    private fun getNumber(): Double {
        val number = mutableList.removeAt(0)
        validateNumber(number)
        return number.toDouble()
    }

    private fun basicOperation(firstNum: Double, secondNum: Double, symbol: String): Double {
        try {
            return basicOperationsCalculator.operation(firstNum, secondNum, symbol)
        } catch (e: IllegalArgumentException) {
            mutableList.clear()
            throw IllegalArgumentException("Please Check the Input")
        }
    }

    fun calculate(input: String): Double {
        mutableList.addAll(input.split(" "))
        var curNum = getNumber()

        while (mutableList.isNotEmpty()) {
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
