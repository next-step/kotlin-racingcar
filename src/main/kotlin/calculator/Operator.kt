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
        fun getByValue(prime: String): Operator {
            val operator = values().find { operator ->
                prime == operator.prime
            }
            require(operator != null){
                "구현되지 않은 기호입니다."
            }
            return operator
        }
    }

    abstract fun execute(preOperand: Int, postOperand: Int): Int
}
