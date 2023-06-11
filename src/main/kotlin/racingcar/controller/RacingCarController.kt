package racingcar.controller

import racingcar.domain.RacingCarGame
import racingcar.domain.RacingGameCarFactory
import racingcar.domain.RandomNumberGenerator
import racingcar.view.RacingCarGameInputView
import racingcar.view.RacingCarGameResultView

class RacingCarController(
    private val racingCarGame: RacingCarGame,
    private val racingCarGameInputView: RacingCarGameInputView,
    private val racingCarGameResultView: RacingCarGameResultView,
) {

    fun gameStart() {
        val carNames = racingCarGameInputView.carNames
        val totalRound = racingCarGameInputView.totalRound

        val randomNumberGenerator = RandomNumberGenerator(
            randomBase = RacingCarGame.RANDOM_NUMBER_BASE,
            randomLimit = RacingCarGame.RANDOM_NUMBER_LIMIT,
        )

        val cars = RacingGameCarFactory.createRandomDriveCars(
            carNames = carNames,
            randomNumberGenerator = randomNumberGenerator,
            RacingCarGame.MIN_RANDOM_DRIVE_NUMBER,
        )

        val gameResult = racingCarGame.progressGame(totalRound = totalRound, cars = cars)

        racingCarGameResultView.print(gameResult = gameResult, totalRound = totalRound)
    }
}
