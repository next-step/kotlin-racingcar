package step2

class StringCalculator {
    companion object {
        fun calculate(input: String?): Int {
            require(!input.isNullOrBlank()) { "입력값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException throw" }

            var result = 0

            input.split(" ").let {
                result += it[0].toInt()
                var operatorIndex = 1
                while (operatorIndex < it.size) {
                    it[operatorIndex].let { operator ->
                        when (operator) {
                            "+" -> result += it[operatorIndex + 1].toInt()
                            "-" -> result -= it[operatorIndex + 1].toInt()
                            "*" -> result *= it[operatorIndex + 1].toInt()
                            "/" -> result /= it[operatorIndex + 1].toInt()
                            else -> throw IllegalArgumentException("지원하지 않는 연산자입니다.")
                        }
                        operatorIndex += 2
                    }
                }
                return result
            }
        }
    }
}
