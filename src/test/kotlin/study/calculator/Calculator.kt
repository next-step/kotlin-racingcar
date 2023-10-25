package study.calculator

class Calculator {

    fun calculate(inputData: String): Int {
        val numAndOperator = createFormula(inputData)

        var result = numAndOperator[0].toInt()

        for (i in 1 until numAndOperator.size step 2) {
            val operator = Operator.from(numAndOperator[i])
            val num = numAndOperator[i + 1]

            result = operator.operation(result, num.toInt())
        }
        return result
    }

    fun createFormula(inputData: String): List<String> {
        val formulaComponent = inputData.split(" ")

        // 입력값이 공백인 경우
        if (inputData.isBlank()) {
            throw IllegalArgumentException("입력 값이 공백입니다.")
        }

        // 수식의 마지막은 숫자.
        if (formulaComponent.size % 2 == 0) {
            throw IllegalArgumentException("수식의 구성이 잘못됐습니다.")
        }

        // 숫자 검증
        for (i in formulaComponent.indices step 2) {
            if (formulaComponent[i].toIntOrNull() == null) throw NumberFormatException("피연산자 항목이 숫자가 아닙니다.")
        }

        // 연산자 검증
        for (i in 1 until formulaComponent.size step 2) {
            Operator.from(formulaComponent[i])
        }

        return formulaComponent
    }
}
