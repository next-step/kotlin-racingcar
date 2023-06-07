package study.step2.equation

sealed class Equation {
    data class Number(val value: Int) : Equation()

    sealed class Operator : Equation() {
        object Plus : Operator()
        object Minus : Operator()
        object Multiply : Operator()
        object Divide : Operator()
    }
}
