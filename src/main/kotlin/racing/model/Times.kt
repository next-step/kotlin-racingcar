package racing.model

class Times(val times: Int) {
    init {
        require(times > 0) { INVALID_TIMES }
    }

    companion object {
        const val INVALID_TIMES = "시도 횟수는 0보다 커야 합니다."
    }
}
