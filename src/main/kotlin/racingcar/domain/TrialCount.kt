package racingcar.domain

private const val POSITIVE_NUMBER_THRESHOLD = 0

class TrialCount(val value: Int) {
    init {
        require(value.isPositive()) { "시도 횟수는 0보다 커야 합니다." }
    }

    fun range(): IntRange {
        return 1..value
    }
}

private fun Int.isPositive(): Boolean {
    return this > POSITIVE_NUMBER_THRESHOLD
}
