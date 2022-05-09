package calculator

class Calculator {
    private var total: Float = 0F

    companion object {
        // const val는 컴파일 시 결정되는 상수이다.
        // const val은 클래스의 생성자에 할당될 수 없다,
        // const val을 함수나 클래스 내에서 사용하려면 companion object이하 중괄호 안에 선언해야 한다.
        // main 함수에서 println(Calculator.OPERATOR_INDEX) 이런식으로 바로 접근이 가능하다.
        private const val TOTAL_INDEX = 0
        private const val OPERATOR_INDEX = 1
        private const val OPERAND_INDEX = 2
        private const val NUMBER_OF_ONE_CALCULATOR_FORMULA_INDEX = 3
    }

    fun calculate(calculatorFormula: String?): Float {
        if (calculatorFormula.isNullOrEmpty()) {
            throw IllegalArgumentException("유효하지 않은 계산식 입니다.")
        }

        val parsedCalculateFormula = this.parseFor(calculatorFormula)

        total = parsedCalculateFormula[TOTAL_INDEX].toFloat()
        val operand = parsedCalculateFormula[OPERAND_INDEX].toFloat()
        val operator = parsedCalculateFormula[OPERATOR_INDEX]

        total = this.calculate(total, operand, operator)

        if (parsedCalculateFormula.size > NUMBER_OF_ONE_CALCULATOR_FORMULA_INDEX) {
            val restParsedCalculateFormula = parsedCalculateFormula.drop(NUMBER_OF_ONE_CALCULATOR_FORMULA_INDEX)
            calculate("$total ${restParsedCalculateFormula.joinToString(" ")}")
        }

        return total
    }

    private val parseFor = { calculatorFormula: String ->
        calculatorFormula.split(' ')
    }

    private val calculate = { a: Float, b: Float, operator: String ->
        Operator.evaluate(a, b, operator)
    }
}
