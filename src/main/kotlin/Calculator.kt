// 수식의 문법상 오류가 있는지 확인하는 클래스
class Calculator() {
    fun calculate(expression: String?): Int {
        // 수식이 null 혹은 공백인지 확인
        nullOrEmptyCheck(expression)

        // 입력받은 문자열 공백 제거 및 배열로 변경
        val arrExpression: Array<String> =
            expression?.split(" ".toRegex())?.dropLastWhile { it.isEmpty() }?.toTypedArray() as Array<String>

        // 1. 나누기가 나왔을 시 . 다음 피연산자가 0일 경우 확인 , 2.수식에서 사칙연산 외의 기호가 있는지 확인
        var i = 1
        while (i < arrExpression.size) {
            operatorCheck(arrExpression[i] , arrExpression[i+1])
            i += 2
        }

        // 본격적인 수식 계산 클래스
        val operator = Operator()
        return operator.operate(arrExpression)
    }

    private fun operatorCheck(operator: String , operand2: String) {
        if (operator == "/" && operand2 == "0") {
            throw ArithmeticException("분모는 0이 될 수 없습니다.")
        }
        if (operator != "+" && operator != "-" && operator != "*" && operator != "/") {
            throw IllegalArgumentException("사칙연산 기호가 아닙니다.")
        }
    }

    private fun nullOrEmptyCheck(expression: String?) {
        if (expression.isNullOrEmpty()) {
            throw IllegalArgumentException("계산식이 NULL 혹은 공백입니다.")
        }
    }
}
