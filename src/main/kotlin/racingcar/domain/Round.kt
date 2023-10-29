package racingcar.domain

@JvmInline
value class Round(val value: Int) {

    init {
        require(value in MIN_ROUND..MAX_ROUND) {
            "$MIN_ROUND ~ $MAX_ROUND 사이의 라운드만 입력할 수 있습니다."
        }
    }

    fun next(): Round = Round(this.value + 1)

    companion object {
        private const val MIN_ROUND = 1
        private const val MAX_ROUND = 100
    }
}
