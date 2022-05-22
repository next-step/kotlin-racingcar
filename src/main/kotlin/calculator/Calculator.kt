package calculator

fun String?.tokenize(): List<String> = this?.trim()?.split("\\s+".toRegex())?.filter { it != "" }
    ?: throw IllegalArgumentException("Null cannot be tokenized")

fun List<String>.parse(): Expression {
    fun parse(exp: Expression, tokenList: List<String>): Expression {
        if (tokenList.isEmpty()) return exp

        val newExp = when (val parsed = Expression.parse(tokenList.first())) {
            is Expression.Operand -> when (exp) {
                Expression.Undefined -> parsed
                is Expression.Operator -> exp.also { it.secondOperand = parsed }
                else -> throw IllegalArgumentException("Invalid expression")
            }
            is Expression.Operator -> parsed.also { it.firstOperand = exp }
            else -> throw IllegalArgumentException("Invalid expression")
        }

        return parse(newExp, tokenList.drop(1))
    }

    return parse(Expression.Undefined, this)
}

fun String?.calculate(): Int = this.tokenize().parse().eval()

sealed class Expression {

    abstract fun eval(): Int

    object Undefined : Expression() {

        override fun eval(): Int {
            throw IllegalArgumentException("Incomplete expression")
        }
    }

    data class Operator(
        val function: (Int, Int) -> Int,
        var firstOperand: Expression = Undefined,
        var secondOperand: Expression = Undefined
    ) : Expression() {

        override fun eval(): Int {
            return function(firstOperand.eval(), secondOperand.eval())
        }
    }

    data class Operand(private val value: Int) : Expression() {
        override fun eval(): Int = value
    }


    companion object {

        fun parse(input: String): Expression {
            return when (input) {
                "+" -> Operator(Int::plus)
                "-" -> Operator(Int::minus)
                "*" -> Operator(Int::times)
                "/" -> Operator(Int::div)
                else -> try {
                    Operand(input.toInt())
                } catch (e: NumberFormatException) {
                    throw IllegalArgumentException(e)
                }
            }
        }
    }
}