package calculator

class Extractor {
    inline fun <reified T : Number> convertStringToNumber(input: String): T {
        return when (T::class) {
            Int::class -> input.toInt() as T
            Double::class -> input.toDouble() as T
            else -> throw IllegalArgumentException("지원하지 않는 숫자 형식입니다.")
        }
    }

    fun extractOperators(input: List<String>): ArrayList<String> {
        val operatorQueue = ArrayList<String>()
        input.forEachIndexed { index, value ->
            if (index % 2 != 0) {
                if (!Operators.findBySymbol(value)) {
                    throw IllegalArgumentException("지원하지 않는 연산자입니다.")
                }
                operatorQueue.add(value)
            }
        }
        return operatorQueue
    }

    inline fun <reified T : Number> extractOperands(input: List<String>): ArrayList<T> {
        val numberQueue = ArrayList<T>()
        input.forEachIndexed { index, value ->
            if (index % 2 == 0) {
                try {
                    numberQueue.add(convertStringToNumber(value))
                } catch (e: IllegalArgumentException) {
                    throw IllegalArgumentException("유효한 형식이 아닙니다.")
                }
            }
        }
        return numberQueue
    }
}
