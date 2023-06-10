package racing.application

import racing.domain.Capacity
import racing.domain.Cars

data class RacingInfo(
    val round: Capacity,
    val cars: Cars
)
