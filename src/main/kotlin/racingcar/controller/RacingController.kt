package racingcar.controller

import racingcar.domain.CarInputProvider
import racingcar.domain.CarResultProvider
import racingcar.domain.RacingGame

class RacingController(
    private val racingGame: RacingGame,
    private val carInputProvider: CarInputProvider,
    private val carResultProvider: CarResultProvider,
) {
    fun startRace() {
        val carNames = carInputProvider.getStringInput("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)")
        val attemptNumber = carInputProvider.getIntInput("시도할 횟수는 몇 회 인가요?")

        val cars = racingGame.run(attemptNumber, carNames)
        val racingHistory = cars.getRacingHistory()

        racingHistory.getRounds().forEach { round ->
            carResultProvider.printCars(round)
        }

        carResultProvider.printWinners(cars.getWinners())
    }
}
