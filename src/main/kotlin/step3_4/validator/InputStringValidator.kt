package step3_4.validator

object InputStringValidator {
    /**
     * 3.3과 같이 Double 값이 입력되는 경우 NumberforamtException을 throw 합니다.
     * Double로 변경 후에 Int로 변경해줍니다
     */
    fun checkValidate(inputString: String): Int {
        require(inputString.isNotBlank()) { VALUE_CAN_NOT_BE_NULL }
        inputString.checkStringIsNumber()
        inputString.checkNumberIsMoreThanMinimum()
        return inputString.toInt()
    }

    /**
     * 입력된 값이 숫자로 변환될 수 있는지 체크합니다
     * ex) 3.3이 입력되거나, 문자가 입력 되는 경우 이곳에서 error를 만납니다
     */
    private fun String.checkStringIsNumber() {
        runCatching {
            toDouble()
            toInt()
        }.onFailure {
            error(VALUE_MUST_BE_NUMBER)
        }
    }

    private fun String.checkNumberIsMoreThanMinimum() {
        check(this.toDouble().toInt() >= MINIMUM_VALUE) { VALUE_MUST_BE_MORE_THAN_ONE }
    }

    private const val VALUE_CAN_NOT_BE_NULL = "값이 입력되지 않았습니다"
    private const val VALUE_MUST_BE_NUMBER = "유효한 값이 입력되지 않았습니다"
    private const val VALUE_MUST_BE_MORE_THAN_ONE = "1 이상의 값을 입력해주세요"
    private const val MINIMUM_VALUE = 1
}
