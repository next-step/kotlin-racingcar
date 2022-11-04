package calculator

enum class Operator(val prime: String) {
    ADD("+"),
    SUBTRACT("-"),
    MULTIPLY("*"),
    DIVIDE("/");

    companion object {
        fun findByValue(prime: String): Operator {
            val operator = values().find { operator ->
                prime == operator.prime
            }
            require(operator != null)
            return operator
        }
    }
}
