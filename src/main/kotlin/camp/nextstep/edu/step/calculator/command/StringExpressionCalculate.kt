package camp.nextstep.edu.step.calculator.command

import camp.nextstep.edu.step.calculator.domain.Calculator
import camp.nextstep.edu.step.calculator.domain.Requester
import camp.nextstep.edu.step.calculator.domain.Result

class StringExpressionCalculate : CalculateCommand {

    override fun calculate(requester: Requester): Result {
        requester.validate()
        val numbers = requester.splitExpression()
        val result = calculateByExpressionNumbers(numbers)
        return Result(calculationResult = result)
    }

    /**
     * @description: 숫자 계산을 위한 Long형 변환의 경우 문자열 계산에서만 사용되기에, private으로 선언
     */
    private fun toLong(number: String): Long = number.toLong()

    /**
     * @description: 계산을 구하는 로직의 경우, 문자열 계산기 내의 고유 동작이라 생각하여, private으로 선언
     */
    //TODO : 만약, String 타입의 문자식이 아닌 다른형태의 문자식이 온다면 해당 부분을 공통 함수로 분리할 수 있지 않을까?
    private fun calculateByExpressionNumbers(numbers: List<String>): Long {
        var result = toLong(numbers[0])

        for (i in 1 until numbers.size step 2) {
            val operationSymbols = numbers[i]
            val rngNumber = toLong(numbers[i + 1])

            result = when (operationSymbols) {
                "+" -> Calculator.add(result, rngNumber)
                "-" -> Calculator.subtract(result, rngNumber)
                "*" -> Calculator.multiply(result, rngNumber)
                "/" -> Calculator.divide(result, rngNumber)
                else -> throw IllegalArgumentException("지원하지 않는 연산자입니다.")
            }
        }
        return result
    }

}
