package com.nextstep.jngcii.racingcar.domain

class Record(carCount: Int) {
    private val cars = (INITIAL_INDEX until carCount)
        .map { INITIAL_COUNT }
        .toMutableList()

    val eachCarDrivenDistance get() = cars.map { it.toDistanceShape }

    fun goOrStopEachCar(dice: Dice) = cars.forEachIndexed { index, _ ->
        cars[index] += dice.run().toCount
    }

    private val Int.toDistanceShape get() = List(this) { DASH }.joinToString(EMPTY_STRING)

    private val Boolean.toCount get() = if (this) SINGLE_COUNT else EMPTY_COUNT

    companion object {
        private const val INITIAL_INDEX = 0

        private const val INITIAL_COUNT = 0
        private const val EMPTY_COUNT = 0
        private const val SINGLE_COUNT = 1

        private const val EMPTY_STRING = ""
        private const val DASH = "-"
    }
}
