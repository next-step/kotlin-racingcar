package calculator

enum class Operator(val prime: String) {
    ADD("+"),
    SUBTRACT("-"),
    MULTIPLY("*"),
    DIVIDE("/");

    companion object {
        fun findByValue(prime: String): Operator {
            Operator.values()
                .forEach { operator ->
                    if (prime == operator.prime) {
                        return operator
                    }
                }
            throw IllegalArgumentException("해당하는 연산자 enum 을 찾을 수 없습니다")
        }
    }
}
