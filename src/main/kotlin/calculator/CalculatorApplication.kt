package calculator

fun main() {
    println(Const.OutputMsg.INIT_MSG)

    val inputStr = readlnOrNull()
    println("입력하신 문자열은 $inputStr 입니다.")

    val expression = InputProcessor.checkInputIsEmpty(inputStr)
    val (operators, operands) = InputProcessor.splitInputToPairList(expression)

    val result = CalculatorProcessor.calculate(operators, operands)

    println("입력 결과는 $result 입니다.")
}
