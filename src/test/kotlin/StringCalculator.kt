import java.lang.IllegalArgumentException

enum class CalculatorByOperator {
    PLUS {
        override fun returnOperator(num1: Int, num2: Int): Int {
            return num1 + num2
        }
    },
    MINUS {
        override fun returnOperator(num1: Int, num2: Int): Int {
            return num1 - num2
        }
    },
    MULTIPLY {
        override fun returnOperator(num1: Int, num2: Int): Int {
            return num1 * num2
        }
    },
    DIVIDE {
        override fun returnOperator(num1: Int, num2: Int): Int {
            return num1 / num2
        }
    };
    abstract fun returnOperator(num1: Int, num2: Int): Int
}

class StringCalculator {

    var result: Int = 0
    var validationCheck = ValidationCheck()

    fun checkUserInput(inputCalculator: String) {
        validationCheck.checkUserInputIsBlankOrEmpty(inputCalculator)
        validationCheck.checkUserInputTempate(inputCalculator)
    }

    fun runStringCalculator(inputCalculator: String): Int {

        try {
            checkUserInput(inputCalculator)
            var calculatorLists = inputCalculator.trim().split(" ")

            result = calculatorLists[0].toInt()
            for (operator in 1..calculatorLists.size - 1 step 2) {
                val resultOperator = calculatorLists[operator]
                val nextNum = calculatorLists[operator + 1].toInt()

                when (resultOperator) {
                    "+" -> result = CalculatorByOperator.PLUS.returnOperator(result, nextNum)
                    "-" -> result = CalculatorByOperator.MINUS.returnOperator(result, nextNum)
                    "*" -> result = CalculatorByOperator.MULTIPLY.returnOperator(result, nextNum)
                    "/" -> result = CalculatorByOperator.DIVIDE.returnOperator(result, nextNum)
                }
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
