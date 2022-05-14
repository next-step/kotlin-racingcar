package car_racing

object ErrorMessage {
    fun getErrorMessageForOnlyIntegerString(parameterName: String, parameterValue: String): String {
        return "입력 받은 \"${parameterValue}\" 은 정수가 아닙니다. ${parameterName}에 정수만을 입력해주세요. "
    }
}
