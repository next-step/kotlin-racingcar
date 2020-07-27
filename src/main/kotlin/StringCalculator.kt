import java.lang.IllegalArgumentException

enum class CalculatorByOperator(val operator: String, val resultCalculator: (Int, Int) -> Int) {
    PLUS("+", { num1, num2 -> num1 + num2 }),
    MINUS("-", { num1, num2 -> num1 - num2 }),
    MULTIPLY("*", { num1, num2 -> num1 * num2 }),
    DIVIDE("/", { num1, num2 -> num1 / num2 });

    companion object {
        fun invokeCalculatorByOperator(inputOperator: String): CalculatorByOperator =
            values().find { findOperator -> findOperator.operator == inputOperator } ?: throw IllegalArgumentException("연산자는 [+, -, *, /]만 사용할 수 있습니다.")
    }
}

class StringCalculator {

    private fun checkUserInput(inputCalculator: String) {
        ValidationChecker.checkUserInputIsBlankOrEmpty(inputCalculator)
    }

    fun runStringCalculator(inputCalculator: String): Int {

        var result: Int

        try {
            checkUserInput(inputCalculator)
            val calculatorValueLists = inputCalculator.trim().split(" ")

            result = calculatorValueLists[0].toInt()
            for (value in 1 until calculatorValueLists.size - 1 step 2) {
                val resultOperator = calculatorValueLists[value]
                val nextNum = calculatorValueLists[value + 1].toInt()

                result = CalculatorByOperator.invokeCalculatorByOperator(resultOperator)
                    .resultCalculator(result, nextNum)
            }
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("숫자외의 값을 입력할 수 없습니다.")
        } catch (e: ArithmeticException) {
            throw IllegalArgumentException("0으로 나눌 수 없습니다.")
        }

        return result
    }
}

fun main() {
    val calculator = StringCalculator()

    print("계산식을 입력하세요(2 + 3 * 4)")
    val inputCalculator = readLine().toString()
    val resultCalculrator = calculator.runStringCalculator(inputCalculator)
    print("[결과] $inputCalculator 의 값은? $resultCalculrator")
}
