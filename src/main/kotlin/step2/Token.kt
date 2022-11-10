package step2

data class Token private constructor(
    val type: TokenType,
    val value: String,
) {
    fun isOperator(): Boolean {
        return this.type.isOperator()
    }

    fun isOperand(): Boolean {
        return this.type.isOperand()
    }

    fun getOperator(): Operator {
        check(this.isOperator()) { "연산자 유형인 경우에만 연산자를 구할 수 있습니다." }
        return Operator.getByLabel(label = value)
    }

    fun getOperatorSign(): OperatorSign {
        check(this.isOperator()) { "연산자 유형인 경우에만 연산 기호를 구할 수 있습니다." }
        return OperatorSign.getBySign(sign = this.value)
    }

    fun getOperand(): Int {
        check(this.isOperand()) { "피연산자 유형인 경우에만 피연산자 숫자를 구할 수 있습니다." }
        return this.value.toInt()
    }

    companion object {
        fun from(value: String): Token {
            val tokenType = TokenType.getByValue(value = value)
            return Token(
                type = tokenType,
                value = value,
            )
        }
    }
}
