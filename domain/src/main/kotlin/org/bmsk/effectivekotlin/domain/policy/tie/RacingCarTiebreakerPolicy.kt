package org.bmsk.effectivekotlin.domain.policy.tie

import org.bmsk.effectivekotlin.domain.model.Car
import org.bmsk.effectivekotlin.domain.model.Cars

internal sealed interface RacingCarTiebreakerPolicy {
    fun breakTie(tiedCars: Cars): Car

    object FirstCarWins : RacingCarTiebreakerPolicy {
        override fun breakTie(tiedCars: Cars): Car {
            return tiedCars.first
        }
    }
}
