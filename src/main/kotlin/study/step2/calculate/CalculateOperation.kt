package study.step2.calculate

class CalculateOperation {

    private val operations: Map<String, (Int, Int) -> Int> = mapOf(
        "+" to { result, number -> result + number },
        "-" to { result, number -> result - number },
        "*" to { result, number -> result * number },
        "/" to { result, number ->
            if (number == 0) {
                throw ArithmeticException("0으로 나눌 수 없습니다.")
            } else {
                result / number
            }
        },
    )

    private var result = 0

    fun initOperation() {
        result = 0
    }

    fun operateBySymbol(
        symbol: String,
        number: Int,
    ) {
        operations[symbol]!!.let {
            result = it(result, number)
        }
    }

    fun getKeys(): Set<String> {
        return operations.keys
    }

    fun getResult(): Int {
        return result
    }
}
