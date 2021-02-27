package step2

const val BLANK = " "
const val POSITION_NUM1 = 0
const val POSITION_OPERATOR = 1
const val POSITION_NUM2 = 2
const val TWO_STEP = 2

private val inputManager: Input = Input()
private val operator: Operator = Operator()

fun main() {
    val strFormula = inputManager.checkFormulaValidation(readLine())
    val listFormula = inputManager.convertFormulaToList(strFormula)

    println(calculateFormulaList(listFormula))
}

fun calculateFormulaList(listFormula: List<String>): Int {
    // 맨 앞에 있는 숫자를 결과값으로 먼저 초기화 시켜준다.
    var calculateResult = listFormula[POSITION_NUM1].toInt()

    for (i in 0..listFormula.size - TWO_STEP step TWO_STEP) {

        val operatorResult = operator.operate(
            number1 = calculateResult,
            number2 = listFormula[POSITION_NUM2 + i].toInt(),
            operator = listFormula[POSITION_OPERATOR + i]
        )

        calculateResult = operatorResult
    }

    return calculateResult
}
