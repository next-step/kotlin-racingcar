enum class Operator(val symbol: String) {
    ADD("+"),
    MINUS("-"),
    MULTIPLE("*"),
    DIVIDE("/");

    companion object {
        fun getOperators(): List<String> =
            mutableListOf(
                ADD.symbol,
                MINUS.symbol,
                MULTIPLE.symbol,
                DIVIDE.symbol
            )
    }
}
