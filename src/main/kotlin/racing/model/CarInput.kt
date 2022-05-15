package racing.model

data class CarInput(val carNames: List<String>, val times: Int) {
    init {
        require(carNames.isNotEmpty()) { INVALID_CAR_NAMES }
        require(times > 0) { INVALID_TIMES }
    }

    companion object {
        const val INVALID_CAR_NAMES = "자동차 이름은 1개 이상이여야 합니다."
        const val INVALID_TIMES = "시도 횟수는 0보다 커야 합니다."
    }
}
