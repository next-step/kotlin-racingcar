package racingcar.domain

data class CarName(val text: String) {

    init {
        validateCarName(text)
    }

    private fun validateCarName(text: String) {
        require(text.isNotBlank()) { "빈 값을 입력 할 수 없습니다." }
        require(text.length <= CAR_NAME_LENGTH_LIMIT) { "자동차 이름의 길이는 ${CAR_NAME_LENGTH_LIMIT}자를 초과할 수 없습니다." }
    }

    companion object {
        private const val CAR_NAME_LENGTH_LIMIT = 5
    }
}
