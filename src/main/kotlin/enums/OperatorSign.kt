package enums

enum class OperatorSign(
    val code: String,
    val desc: String
) {
    SUM("+", "덧셈"),
    SUBSTRACT("-", "뺄셈"),
    MULTIPLY("*", "곱셈"),
    DIVIDE("/", "나눗셈")
}
