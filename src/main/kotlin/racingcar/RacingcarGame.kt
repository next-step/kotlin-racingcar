package racingcar

import racingcar.component.Cars
import racingcar.model.RacingcarGameInput
import racingcar.model.RacingcarGameResult
import racingcar.model.log.CarLog
import racingcar.model.log.RoundLog

class RacingcarGame {
    fun play(input: RacingcarGameInput): RacingcarGameResult {
        val cars = Cars.create(input.carNames)
        val rounds = input.rounds

        val roundLogs = doRounds(cars, rounds)

        return RacingcarGameResult(
            winners = cars.getWinners(),
            roundLogs = roundLogs
        )
    }

    private fun doRounds(cars: Cars, rounds: Int): List<RoundLog> {
        val roundLogs = mutableListOf<RoundLog>()

        repeat(rounds) {
            cars.moveCars()
            appendRoundLogs(roundLogs, cars.getCarLogs())
        }

        return roundLogs.toList()
    }

    private fun appendRoundLogs(roundLogs: MutableList<RoundLog>, carLogs: List<CarLog>) {
        val roundLog = RoundLog(carLogs)

        roundLogs.add(roundLog)
    }
}
