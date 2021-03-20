package racingcar.domain

import racingcar.domain.CarConfig.randomNumberGenerator
import racingcar.history.RacingResultHistory
import racingcar.history.RacingRoundHistory
import racingcar.userInput.UserNameInfo

class RacingGame(private val tryCount: Int, private val userNameInfo: UserNameInfo) {

    private val carCollection = CarCollection(userNameInfo.usernames)
    private val racingResultHistory = RacingResultHistory()

    fun runRace(): List<RacingRoundHistory> {
        repeat(tryCount) {
            carCollection.tryMoveCars(conditionNumbers = randomNumberGenerator(carCollection.size()))
            racingResultHistory.logging(round = it, cars = carCollection.cars)
        }
        return racingResultHistory.getResults()
    }

    fun getWinner() = carCollection.getWinner()
}
