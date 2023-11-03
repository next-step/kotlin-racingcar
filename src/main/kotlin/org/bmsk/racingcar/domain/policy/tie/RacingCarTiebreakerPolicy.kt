package org.bmsk.racingcar.domain.policy.tie

import org.bmsk.racingcar.domain.model.Car
import org.bmsk.racingcar.domain.model.Cars

sealed interface RacingCarTiebreakerPolicy {
    fun breakTie(tiedCars: Cars): Car

    object FirstCarWins : RacingCarTiebreakerPolicy {
        override fun breakTie(tiedCars: Cars): Car {
            return tiedCars.first
        }
    }
}
