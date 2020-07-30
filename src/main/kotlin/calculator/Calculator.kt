package calculator

import java.lang.AssertionError
import java.lang.NullPointerException
import java.math.BigDecimal

class Calculator {
    // 상태 값을 갖지 않는 클래스는 객체를 생성해서 메소드에 접근하는 것이 아니라
    // kotlin 의 companion object 를 활용해서 인스턴스를 생성하지 않고 메소드에 접근 가능
    // 자바에서 static 이 붙는 클래스 메소드들을 하기 방식을 이용하면
    companion object {
        private val symbols = listOf("+", "-", "*", "/")

        private fun add(v1: String, v2: String): String = v1.toBigDecimal().plus(v2.toBigDecimal()).toPlainString()

        private fun subtract(v1: String, v2: String): String =
            v1.toBigDecimal().subtract(v2.toBigDecimal()).toPlainString()

        private fun multiply(v1: String, v2: String): String =
            v1.toBigDecimal().multiply(v2.toBigDecimal()).toPlainString()

        private fun divide(v1: String, v2: String): String {
            try {
                return (v1.toBigDecimal().divide(v2.toBigDecimal(), 8, BigDecimal.ROUND_HALF_EVEN)).stripTrailingZeros()
                    .toPlainString()
            } catch (e: ArithmeticException) {
                throw ArithmeticException("무한대")
            }
        }

        private fun checkValidation(mInputs: String?) {
            if (mInputs == null || mInputs.isEmpty()) {
                throw CalculatorException("계산식을 입력해주세요.")
            }
            // TODO 기호가 - 일때 계산기호가 이닌 수 자체가 음수일 어떻게 할 것인가
            val inputs: List<String> = mInputs.split(" ")
            var symbolCount: Int = 0
            var numberCount: Int = 0
            for (input: String in inputs) {
                if (symbols.contains(input) && input.length == 1) {
                    if (input.length == 1) {
                        symbolCount++
                        continue
                    }
                } else {
                    try {
                        input.toBigDecimal()
                        numberCount++
                        if (numberCount > 1 && numberCount - 1 != symbolCount) throw CalculatorException(
                            "숫자 다음에는 반드시 사칙연산 기호가 입력되어야 합니다."
                        )
                    } catch (e: NumberFormatException) {
                        throw NumberFormatException("숫자와 사칙연산 기호 사이 공백이 존재하는지, 사칙연산 기호 외에 다른 기호가 들어갔는지 확인해주세요.")
                    }
                }
            }
        }

        fun calculate(mInputs: String?): String {
            if (mInputs == null) {
                throw NullPointerException("계산식을 입력해주세요.")
            }
            checkValidation(mInputs)
            val inputs: List<String> = mInputs.split(" ")
            var result: String = inputs[0]
            var symbol: String = inputs[0]
            for (input: String in inputs) {
                try {
                    if (symbols.contains(input)) {
                        symbol = input
                    } else {
                        input.toBigDecimal()
                        if (input != result) when (symbol) {
                            "+" -> result = add(result, input)
                            "-" -> result = subtract(result, input)
                            "*" -> result = multiply(result, input)
                            "/" -> result = divide(result, input)
                        }
                    }
                } catch (e: AssertionError) {
                    throw CalculatorException("숫자 다음에는 반드시 사칙연산 기호가 입력되어야 합니다.")
                }
            }
            return result
        }
    }
}
