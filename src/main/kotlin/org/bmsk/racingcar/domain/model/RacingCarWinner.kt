package org.bmsk.racingcar.domain.model

sealed interface RacingCarWinner {
    data class SingleWinner(val car: Car) : RacingCarWinner
    data class MultipleWinner(val cars: List<Car>) : RacingCarWinner
}
