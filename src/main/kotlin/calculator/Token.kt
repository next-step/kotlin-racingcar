package calculator

data class Token(
    val type: Type,
    val literal: String,
) {

    enum class Type {
        NUMBER,
        OPERATOR,
        ;
    }
}
