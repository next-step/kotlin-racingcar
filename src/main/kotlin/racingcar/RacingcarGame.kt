package racingcar

import racingcar.component.Cars
import racingcar.model.RacingcarGameResult
import racingcar.model.RacingcarGameInput
import racingcar.model.log.CarLog
import racingcar.model.log.RoundLog

class RacingcarGame {
    fun play(input: RacingcarGameInput): RacingcarGameResult {
        val cars = Cars.create(input.carNames)
        val rounds = input.rounds

        return play(cars, rounds)
    }

    private fun play(cars: Cars, rounds: Int): RacingcarGameResult {
        val roundLogs = mutableListOf<RoundLog>()

        repeat(rounds) {
            cars.moveCars()
            appendRoundLogs(roundLogs, cars.getCarLogs())
        }

        val winners = cars.getWinners()

        return RacingcarGameResult(
            winners,
            roundLogs.toList()
        )
    }

    private fun appendRoundLogs(roundLogs: MutableList<RoundLog>, carLogs: List<CarLog>) {
        val roundLog = RoundLog(carLogs)

        roundLogs.add(roundLog)
    }
}
