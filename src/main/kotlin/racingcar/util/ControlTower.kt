package racingcar.util

import racingcar.view.input.Input
import racingcar.view.output.Output
import racingcar.domain.cars.RacingCar
import racingcar.domain.racing.FinalLab

object ControlTower {
    fun decideRacingLabs(input: Input, output: Output): FinalLab {
        output.finalLab()
        return FinalLab(value = input.finalLab())
    }

    fun judgeTheWinningRecord(racingCarsList: List<RacingCar>): Int =
        racingCarsList.maxOf(RacingCar::racingDistance)

    fun judgeTheWinnersNames(
        racingCarsList: List<RacingCar>,
        winningRecord: Int
    ) = racingCarsList
        .filter {
            it.racingDistance() == winningRecord
        }.map {
            it.name
        }
}
