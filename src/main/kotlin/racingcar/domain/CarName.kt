package racingcar.domain

data class CarName(val value: String) {
    init {
        require(value.isNotBlank() && value.length <= MAX_NAME_LENGTH) { "Car의 이름은 빈 문자열이 아니고 5자 이하의 문자열만 허용됩니다." }
    }

    companion object {
        private const val MAX_NAME_LENGTH = 5
    }
}
