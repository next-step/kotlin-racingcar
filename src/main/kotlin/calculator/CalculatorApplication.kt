package calculator

fun main() {
    println(Const.OutputMsg.INIT_MSG)

    val expression = readlnOrNull()
    require(!expression.isNullOrBlank()) { Const.ErrorMsg.INPUT_IS_EMPTY_OR_BLANK_ERROR_MSG }


    println("입력하신 문자열은 $expression 입니다.")
}