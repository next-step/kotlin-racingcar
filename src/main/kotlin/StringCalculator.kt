import java.lang.IllegalArgumentException

enum class CalculatorByOperator(val operator: String, var resultCalculator: (Int, Int) -> Int) {
    PLUS("+", { num1, num2 -> num1 + num2 }),
    MINUS("-", { num1, num2 -> num1 - num2 }),
    MULTIPLY("*", { num1, num2 -> num1 * num2 }),
    DIVIDE(
        "/",
        { num1, num2 ->
            if (num2 == 0) throw IllegalArgumentException("0으로 나눌 수 없습니다.")
            num1 / num2
        }
    );

    companion object {
        // operator에 따라 다른 enum 상수를 호출하기
        fun invokeCalculatorByOperator(inputOperator: String): CalculatorByOperator =
            CalculatorByOperator.values().first { it.operator == inputOperator }
    }
}

class StringCalculator {

    var result: Int = 0

    fun checkUserInput(inputCalculator: String) {
        ValidationChecker.checkUserInputIsBlankOrEmpty(inputCalculator)
        ValidationChecker.checkUserInputTempate(inputCalculator)
    }

    fun runStringCalculator(inputCalculator: String): Int {

        try {
            checkUserInput(inputCalculator)
            val calculatorValueLists = inputCalculator.trim().split(" ")

            result = calculatorValueLists[0].toInt()
            for (value in 1..calculatorValueLists.size - 1 step 2) {
                val resultOperator = calculatorValueLists[value]
                val nextNum = calculatorValueLists[value + 1].toInt()

                result = CalculatorByOperator.invokeCalculatorByOperator(resultOperator)
                    .resultCalculator(result, nextNum)
            }
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("숫자외의 값을 입력할 수 없습니다.")
        }

        return result
    }
}

fun main() {
    val calculator = StringCalculator()

    print("계산식을 입력하세요(2 + 3 * 4)")
    val inputCalculator = readLine().toString()
    val resultCalculrator = calculator.runStringCalculator(inputCalculator)
    print("[결과] $inputCalculator 의 값은? " + resultCalculrator)
}
