package racingcar.domain

import racingcar.domain.CarConfig.randomNumberGenerator
import racingcar.history.RacingRoundHistory
import racingcar.userInput.UserNameInfo

class RacingGame(private val tryCount: Int, private val userNameInfo: UserNameInfo) {

    private val carCollection = CarCollection(userNameInfo.usernames)

    fun runRace(): List<RacingRoundHistory> {
        repeat(tryCount) {
            carCollection.tryMoveCars(round = it, conditionNumbers = randomNumberGenerator(carCollection.size()))
        }
        return carCollection.getRacingHistories()
    }
}
