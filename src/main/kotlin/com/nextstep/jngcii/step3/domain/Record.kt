package com.nextstep.jngcii.step3.domain

class Record(
    private val carCount: Int
) {
    companion object {
        private const val INITIAL_INDEX = 0

        private const val INITIAL_COUNT = 0
        private const val SINGLE_COUNT = 1
    }

    private val goCounts = (INITIAL_INDEX until carCount)
        .map { INITIAL_COUNT }
        .toMutableList()

    fun write(carIndex: Int, canGo: Boolean) {
        if (carIndex < INITIAL_INDEX || carIndex >= carCount) {
            throw IllegalArgumentException("0 <= n < $carCount 의 숫자만 입력 가능합니다.")
        }

        goCounts[carIndex] = canGo.toCount()
    }

    private fun Boolean.toCount() = if (this) 1 else 0
}
