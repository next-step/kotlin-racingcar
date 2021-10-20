package racingcar.domain

@JvmInline
value class CarName private constructor(val value: String) {
    companion object {
        private const val MAXIMUM_CAR_NAME_LEGNTH = 5
        private const val ENTERED_WRONG_CAR_NAME = "잘못된 자동차 이름입니다. ${MAXIMUM_CAR_NAME_LEGNTH}글자 이하의 이름을 입력하세요."

        fun from(value: String?): CarName {
            require(value != null && value.isNotBlank() && value.length <= MAXIMUM_CAR_NAME_LEGNTH) { ENTERED_WRONG_CAR_NAME }
            return CarName(value)
        }
    }
}
