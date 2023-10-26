package week1.calculator

enum class OperatorType(
    val value: String,
) {
    ADD("+"),
    SUBTRACT("-"),
    MULTIPLY("*"),
    DIVIDE("/"),
    ;

    companion object {
        fun from(value: String): OperatorType {
            return OperatorType.values().firstOrNull { it.value == value } ?: throw IllegalArgumentException()
        }
    }
}