package racingcar.domain

data class Position(val value: Int = DEFAULT_POSITION) {
    init {
        require(value >= DEFAULT_POSITION) { "position은 최소 $DEFAULT_POSITION 이상이어야 합니다." }
    }

    companion object {
        const val DEFAULT_POSITION = 1
    }
}
