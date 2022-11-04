package calculator

sealed interface Operator {

    object Plus : Operator
    object Minus : Operator
    object Multiply : Operator
    object Divide : Operator

    companion object {
        operator fun invoke(symbol: String): Operator =
            TODO("Not Implemented")
    }
}