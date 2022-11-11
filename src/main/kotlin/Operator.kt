// 실제 계산 연산을 진행하는 클래스
class Operator {

    fun operate(arrExpression: Array<String>): Int {
        var i = 0
        var result = arrExpression[0].toInt()
        while (i < arrExpression.size) {
            result = finishOperandCheck(arrExpression, i, arrExpression.size - 1, result)
            i += 2
        }
        return result
    }

    /** 현재 피연산자가 마지막 피연산자임을 확인 */
    private fun finishOperandCheck(
        arrExpression: Array<String>,
        currentIndex: Int,
        finishIndex: Int,
        result: Int
    ): Int {
        if (currentIndex != finishIndex) {
            return operatorCheck(result, arrExpression[currentIndex + 1], arrExpression[currentIndex + 2].toInt())
        }
        return result
    }

    /** 연산 기호를 확인하고 그에 맞는 함수 호출 */
    private fun operatorCheck(operand1: Int, operator: String, operand2: Int): Int {
        var result = 0
        when (operator) {
            "+" ->
                result = sum(operand1, operand2)

            "-" ->
                result = minus(operand1, operand2)

            "*" ->
                result = multiply(operand1, operand2)

            "/" ->
                result = divide(operand1, operand2)
        }
        return result
    }

    private fun sum(operando1: Int, operando2: Int): Int {
        return operando1 + operando2
    }

    private fun minus(operando1: Int, operando2: Int): Int {
        return operando1 - operando2
    }

    private fun multiply(operando1: Int, operando2: Int): Int {
        return operando1 * operando2
    }

    private fun divide(operando1: Int, operando2: Int): Int {
        return operando1 / operando2
    }
}