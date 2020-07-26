import java.lang.IllegalArgumentException

object ValidationChecker {
    fun checkUserInputIsBlankOrEmpty(userInput: String) {
        if (userInput.equals("") || userInput.equals(" ")) {
            throw IllegalArgumentException("공백 또는 빈 문자열을 입력하셨습니다.")
        }
    }

    fun checkUserInputTempate(userInput: String) {

        var splitUserInput = userInput.trim().split(" ")
        var resultValue = splitUserInput[0]

        for (operatorIndex in 1 until splitUserInput.size - 1 step 2) {
            val resultOperator = splitUserInput[operatorIndex]
            val nextNum = splitUserInput[operatorIndex + 1]
            checkOperator(resultOperator)
            checkDivideByZero(resultOperator, nextNum)
        }
    }

    private fun checkOperator(userInputOperator: String) {
        val operatorList = arrayOf("+", "-", "*", "/")
        if (!operatorList.contains(userInputOperator)) {
            throw IllegalArgumentException("연산자는 [+, -, *, /]만 사용할 수 있습니다.")
        }
    }

    private fun checkDivideByZero(operator: String, num: String) {
        if (operator.equals("/") && num.equals("0")) {
            throw ArithmeticException("0으로 나눌 수 없습니다.")
        }
    }
}
