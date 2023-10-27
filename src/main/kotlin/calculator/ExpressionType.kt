package calculator

sealed interface ExpressionType {
    fun isSameType(other: ExpressionType): Boolean

    enum class Operator : ExpressionType {
        Add,
        Sub,
        Multi,
        Div;

        override fun isSameType(other: ExpressionType): Boolean {
            return other is Operator
        }
    }

    data class Term(val value: Int) : ExpressionType {
        operator fun plus(other: Term): Term {
            val result = value + other.value

            return Term(result)
        }

        operator fun minus(other: Term): Term {
            val result = value - other.value

            return Term(result)
        }

        operator fun times(other: Term): Term {
            val result = value * other.value

            return Term(result)
        }

        operator fun div(other: Term): Term {
            val result = value / other.value

            return Term(result)
        }

        override fun isSameType(other: ExpressionType): Boolean {
            return other is Term
        }
    }
}
