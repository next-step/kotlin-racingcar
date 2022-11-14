package calculator.enums

enum class ExceptionCode(
    private val message: String,
) {
    NOT_ALLOWED_NULL_OR_BLANK("input이 null이거나 빈 문자열일 수 없습니다"),
    NOT_MATCHED_NUMERIC("input이 숫자가 적절한 위치가 아닙니다"),
    NOT_MATCHED_OPERATOR("input이 연산자가 적절한 위치가 아닙니다"),
    NOT_DIVIDE_ZERO("0으로 나누기 연산을 할 수 없습니다")
    ;

    fun getMessage(): String {
        return this.message
    }
}
