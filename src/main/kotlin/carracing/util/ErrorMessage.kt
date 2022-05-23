package carracing.util

object ErrorMessage {

    fun getMinNumberError(value: Int, minValue: Int): String = "${value}은 올수 없습니다. 최소 값($minValue)이상의 값을 넣어주세요."
    fun getMaxNumberError(value: Int, maxValue: Int): String = "${value}은 올수 없습니다. 최대 값($maxValue)이하의 값을 넣어주세요."
    fun getErrorMessageForOnlyIntegerString(parameterName: String, parameterValue: String): String {
        return "입력 받은 \"${parameterValue}\" 은 정수가 아닙니다. ${parameterName}에 정수만을 입력해주세요. "
    }
}
