package step3.racingcar.domain

interface RandomNumber {
    fun value(): Int

    companion object {
        const val RANGE_START = 1
        const val RANGE_END = 9
    }
}
