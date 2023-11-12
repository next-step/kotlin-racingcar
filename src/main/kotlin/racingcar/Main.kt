package racingcar

import racingcar.domain.CarFactory
import racingcar.domain.RacingGame
import racingcar.domain.RandomPowerEngine
import racingcar.view.printRacingGameResult
import racingcar.view.readCarNames
import racingcar.view.readTryCount

fun main() {
    val carNames = readCarNames()
    val tryCount = readTryCount()
    val cars = CarFactory.createCars(carNames)
    val racingGame = RacingGame(cars, tryCount)
    val racingGameResults = racingGame.run(RandomPowerEngine())
    printRacingGameResult(racingGameResults)
}
