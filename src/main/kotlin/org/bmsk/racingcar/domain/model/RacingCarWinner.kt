package org.bmsk.racingcar.domain.model

sealed interface RacingCarWinner {
    val winnerNames: List<String>

    data class SingleWinner(private val car: Car) : RacingCarWinner {
        override val winnerNames: List<String>
            get() = listOf(car.name)
    }

    data class MultipleWinner(private val cars: Cars) : RacingCarWinner {
        override val winnerNames: List<String>
            get() = cars.names
    }
}
