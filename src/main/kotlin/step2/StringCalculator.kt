package step2

class StringCalculator {
    companion object {
        fun calculate(input: String?): Int {
            require(!input.isNullOrBlank()) { "입력값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException throw" }

            input.split(" ").let {
                it[1].let { operator ->
                    return when (operator) {
                        "+" -> it[0].toInt() + it[2].toInt()
                        "-" -> it[0].toInt() - it[2].toInt()
                        "*" -> it[0].toInt() * it[2].toInt()
                        "/" -> it[0].toInt() / it[2].toInt()
                        else -> throw IllegalArgumentException("지원하지 않는 연산자입니다.")
                    }
                }
            }
        }
    }
}
