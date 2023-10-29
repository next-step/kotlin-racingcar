package week1.calculator

object Calculator {

    private const val DELIMITER = ' '

    fun process(input: String?): Int {
        require(!input.isNullOrBlank()) {
            if (input == null) "식이 null입니다." else "비어 있는 식입니다."
        }

        val numbers = mutableListOf<Int>()
        val operators = mutableListOf<OperatorType>()
        input.split(DELIMITER).forEach { chunk ->
            if (OperatorType.isOperatorSymbol(chunk)) {
                OperatorType.from(chunk)?.let {
                    operators.add(it)
                }
            } else {
                numbers.add(chunk.toInt())
            }
        }

        var result = numbers.first()
        operators.forEachIndexed { idx, operatorType ->
            val a = result
            val b = numbers[idx + 1]

            result = operatorType.execute(a, b)
        }
        return result
    }
}