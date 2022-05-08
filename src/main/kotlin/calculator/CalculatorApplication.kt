package calculator

fun main() {
    println(Const.OutputMsg.INIT_MSG)

    val expression = readlnOrNull()

    val (operators, operands) = InputProcessor.splitInputToPairList(InputProcessor.checkInputIsEmpty(expression))

    println("입력하신 문자열은 $expression 입니다.")
    println("연산자는 $operators, 피연산자는 $operands 입니다.")
}
