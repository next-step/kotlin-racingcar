package study.step2

enum class OperatorEnum(val operator: String) {
    PLUS("+"),
    MINUS("-"),
    TIMES("*"),
    DIVIDE("/");

    companion object {
        fun exist(operator: String): Boolean {
            OperatorEnum.values()
                .forEach { s ->
                    if (operator == s.operator) return true
                }
            return false
        }
    }
}
