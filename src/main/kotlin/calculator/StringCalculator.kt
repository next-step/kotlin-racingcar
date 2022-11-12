package calculator

object StringCalculator {

    fun calculate(input: String?): Long {

        require(!input.isNullOrBlank()) { "입력값은 null이나 빈 공백 문자일 수 없습니다." }

        val split: List<String> = input.split(" ")

        var result = split[0].toLong()
        for (i in 1 until split.size step 2) {

            val operator = ArithmeticOperator.of(split[i])
            val operand = split[i + 1].toLong()

            result = operator.operate(result, operand)
        }

        return result
    }
}
