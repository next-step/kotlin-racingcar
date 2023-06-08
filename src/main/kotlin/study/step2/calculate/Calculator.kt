package study.step2.calculate

class Calculator {

    fun calculate(targetStr: String?): Int {
        require(targetStr.isNotNullAndNotBlank()) { "문자열을 null 이거나 빈 문자열일 수 없습니다." }
        var symbol = OperationSymbol.initPlusSymbol()
        var result = 0
        targetStr!!.split(" ").map { eachSymbol ->
            when (val number = eachSymbol.toIntOrNull()) {
                null -> symbol = OperationSymbol.findBySymbol(eachSymbol)
                else -> result = symbol.operate(result, number)
            }
        }

        return result
    }
}

fun String?.isNotNullAndNotBlank(): Boolean {
    return !this.isNullOrBlank()
}
