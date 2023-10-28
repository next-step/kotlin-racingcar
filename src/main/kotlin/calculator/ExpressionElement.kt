package calculator

import java.lang.IllegalArgumentException

sealed interface ExpressionElement {
    fun isSameType(other: ExpressionElement): Boolean

    enum class Operator : ExpressionElement {
        Add,
        Sub,
        Multi,
        Div;

        override fun isSameType(other: ExpressionElement): Boolean {
            return other is Operator
        }

        companion object {
            fun find(value: String): Operator {
                return when (value) {
                    "+" -> ExpressionElement.Operator.Add
                    "-" -> ExpressionElement.Operator.Sub
                    "*" -> ExpressionElement.Operator.Multi
                    "/" -> ExpressionElement.Operator.Div

                    else -> throw IllegalArgumentException("Not supported operator")
                }
            }
        }
    }

    data class Term(val value: Int) : ExpressionElement {
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

        override fun isSameType(other: ExpressionElement): Boolean {
            return other is Term
        }
    }
}
