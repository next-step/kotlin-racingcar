package racingcar.communication

import racingcar.communication.input.Input
import racingcar.communication.output.Output
import racingcar.domain.cars.RacingCar
import racingcar.domain.racing.FinalLab

object ControlTower {
    fun decideRacingLabs(input: Input, output: Output): FinalLab {
        output.finalLab()
        return FinalLab(value = input.finalLab())
    }

    fun judgeTheWinningRecord(racingCarsList: List<RacingCar>): Int =
        racingCarsList.maxOf { it.racingDistance() }

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
