package org.bmsk.racingcar.domain.policy.tie

import org.bmsk.racingcar.domain.model.Car

sealed interface RacingCarTiebreakerPolicy {
    fun breakTie(tiedCars: List<Car>): Car

    object FirstCarWins : RacingCarTiebreakerPolicy {
        override fun breakTie(tiedCars: List<Car>): Car {
            return tiedCars.first()
        }
    }

    object RandomCarWins : RacingCarTiebreakerPolicy {
        override fun breakTie(tiedCars: List<Car>): Car {
            return tiedCars.random()
        }
    }

    object NameOrderWins : RacingCarTiebreakerPolicy {
        override fun breakTie(tiedCars: List<Car>): Car {
            return tiedCars.minBy { it.name }
        }
    }
}
