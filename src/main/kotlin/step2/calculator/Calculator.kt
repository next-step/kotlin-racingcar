package step2.calculator

class Calculator {
    fun execute(input: String?): Long {
        input ?: throw IllegalArgumentException("유효하지 않은 입력 값입니다.")
        return this.calculate(input.split(DELIMITER))
    }

    private fun calculate(input: List<String>): Long {
        val splitter = Splitter(input)
        val arithmeticParameter = splitter.arithmeticArithmeticParameter
        val result = arithmeticParameter.calculate(splitter.left, splitter.right)

        if (splitter.hasOther) {
            return calculate(listOf(result.toString()) + input.drop(3))
        }

        return result
    }

    companion object {
        const val DELIMITER = " "
    }
}
