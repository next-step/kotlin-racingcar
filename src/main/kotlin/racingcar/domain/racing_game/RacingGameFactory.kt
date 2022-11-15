package racingcar.domain.racing_game

import racingcar.domain.random.DefaultRandomGenerator
import racingcar.model.Car
import racingcar.model.CompeteCar
import racingcar.model.DefaultCar
import racingcar.model.GameMode
import racingcar.ui.InputView

class RacingGameFactory {
    fun create(mode: GameMode): RacingGame = when (mode) {
        GameMode.DEFAULT -> {
            val carNum = InputView.requestCarNum()
            val cars = List<Car>(carNum) { DefaultCar() }
            DefaultRacingGame(DefaultRandomGenerator(), cars)
        }

        GameMode.COMPETE -> {
            val carNames = InputView.requestCarNames()
            val cars = List<Car>(carNames.size) { index -> CompeteCar(carNames[index], DefaultCar()) }
            CompeteRacingGame(DefaultRacingGame(DefaultRandomGenerator(), cars))
        }
    }
}
