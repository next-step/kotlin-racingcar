package calculator

enum class Operator(val prime: String) {
    ADD("+") {
        override fun execute(preOperand: Int, postOperand: Int): Int = preOperand + postOperand
    },
    SUBTRACT("-") {
        override fun execute(preOperand: Int, postOperand: Int): Int = preOperand - postOperand
    },
    MULTIPLY("*") {
        override fun execute(preOperand: Int, postOperand: Int): Int = preOperand * postOperand
    },
    DIVIDE("/") {
        override fun execute(preOperand: Int, postOperand: Int): Int = preOperand / postOperand
    };

    companion object {
        fun findByValue(prime: String): Operator {
            val operator = values().find { operator ->
                prime == operator.prime
            }
            require(operator != null)
            return operator
        }
    }

    abstract fun execute(preOperand: Int, postOperand: Int): Int
}
