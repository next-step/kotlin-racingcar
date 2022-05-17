package com.nextstep.jngcii.racingcar.domain

class Record(
    val carCount: Int,
    val trialCount: Int
) {
    private val goCounts = (INITIAL_INDEX until carCount)
        .map { INITIAL_COUNT }
        .toMutableList()

    fun getGoCount(carIndex: Int): Int {
        carIndex.validate()

        return goCounts[carIndex]
    }

    fun write(carIndex: Int, canGo: Boolean) {
        carIndex.validate()

        if (goCounts[carIndex] + SINGLE_COUNT > trialCount) {
            throw IllegalStateException("최대 전진 횟수는 시도 횟수보다 클 수 없습니다.")
        }

        goCounts[carIndex] += canGo.toCount()
    }

    private fun Int.validate() {
        if (this < INITIAL_INDEX || this >= carCount) {
            throw IllegalArgumentException("0 <= n < $carCount 의 숫자만 입력 가능합니다.")
        }
    }

    private fun Boolean.toCount() = if (this) SINGLE_COUNT else EMPTY_COUNT

    companion object {
        private const val INITIAL_INDEX = 0

        private const val INITIAL_COUNT = 0
        private const val EMPTY_COUNT = 0
        private const val SINGLE_COUNT = 1
    }
}
