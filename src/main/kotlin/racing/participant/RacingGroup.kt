package racing.participant

import racing.result.RoundResult
import racing.result.toRoundResult

class RacingGroup(
    private val cars: List<RacingCar>
) {
    fun race(round: Int): RoundResult {
        return cars.map { racingCar -> racingCar.run() }
            .toRoundResult(round)
    }
}

fun List<RacingCar>.toCarGroup(): RacingGroup {
    return RacingGroup(this)
}