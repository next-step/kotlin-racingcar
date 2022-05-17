package step2

object StringParser {
    private val operatorSymbols = Operator.symbols // 연산기호 문자열 리스트
    const val NumberFormatExceptionErrorMessage = "숫자 형식이 아닙니다"

    // 입력된 문자열로부터 공백을 모두 제거하고, 연산기호("+", "-", "*", "/") 주변에만 공백을 갖도록 문자열 파씽
    fun parseByOperatorSymbols(string: String): String = string
        .split("")
        .filter { it.isNotBlank() }
        .joinToString("") { if (operatorSymbols.contains(it)) " $it " else it }

    // 입력된 문자열로부터 연산기호를 기준으로 split 된 문자열 리스트 반환
    fun listByOperatorSymbol(string: String): List<String> = parseByOperatorSymbols(string).split(" ")

    // 입력된 문자열로부터 Double 전환값을 반환. 에러 발생시 toDoubleErrorMessage 에러 throw
//    fun toDouble(string: String): Double = try {
//        string.toDouble()
//    } catch (e: NumberFormatException) {
//        println(e)
//        throw IllegalArgumentException(NumberFormatExceptionErrorMessage)
//    }
    fun toDouble(string: String) =
        string.toDoubleOrNull() ?: throw IllegalArgumentException(NumberFormatExceptionErrorMessage)
}
