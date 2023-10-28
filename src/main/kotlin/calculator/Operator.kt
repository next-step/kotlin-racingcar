package calculator

enum class Operator(val symbol: String) {
    PLUS("+"), MINUS("-"), MULTIPLY("*"), DIVIDE("/");

    companion object {
        infix fun from(symbol: String): Operator {
            require(Operator.values().map { it -> it.symbol }.contains(symbol)) { "Wrong operator!" }

            return Operator.values().first() { it.symbol == symbol }
        }
        // fun from(symbol: String): Operator {
        //     require(Operator.values().map { it -> it.symbol }.contains(symbol)) { "Wrong operator!" }
        //
        //     return Operator.values().first() { it.symbol == symbol }
        // }
    }
}
