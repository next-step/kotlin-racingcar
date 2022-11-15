package racingcar

import racingcar.domain.CarRacer
import racingcar.domain.CarRacing
import racingcar.domain.Name
import racingcar.domain.RandomCarControl
import racingcar.domain.StandardCar
import racingcar.domain.Winner
import racingcar.view.InputView
import racingcar.view.OutputView

fun main() {
    try {
        val carRacing = CarRacing(carRacers = createCarRacers(), count = InputView.readTryCount())

        OutputView.writeResult(carRacing.race())
        OutputView.writeWinner(Winner(carRacing))
    } catch (e: RuntimeException) {
        OutputView.writeError(e)
    }
}

private fun createCarRacers(): List<CarRacer> = InputView.readCarNames()
    .map { CarRacer(StandardCar(name = Name(it)), RandomCarControl()) }
