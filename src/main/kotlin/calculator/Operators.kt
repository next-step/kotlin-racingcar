package calculator

object Operators {
    private val operators: MutableMap<String, Operator> = HashMap()

    init {
        operators["+"] = Operator.PLUS
        operators["-"] = Operator.MINUS
        operators["*"] = Operator.MULTI
        operators["/"] = Operator.DIVIDE
    }

    fun getOperator(stringOperate: String): Operator {
        return operators[stringOperate] ?: throw IllegalArgumentException()
    }
}
