package calculator

fun main() {
    val calculatorFormula = readln()

    require(calculatorFormula.isNotEmpty()) { "유효하지 않은 계산식 입니다." }

    println(Calculator.calculate(calculatorFormula))
}
