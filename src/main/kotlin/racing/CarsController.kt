package racing

import racing.domain.CarName
import racing.domain.CarsFactory
import racing.domain.Round
import racing.view.CarsDto
import racing.view.InputView
import racing.view.OutputView

object CarsController {

    fun play() {
        val names = CarName.from(InputView.getCarsName())
        val cars = CarsFactory.create(names)
        val round = Round(InputView.getRound())

        OutputView.printStartResult()
        repeat(round.value) {
            cars.goAll()
            OutputView.printResult(CarsDto(cars))
        }
        OutputView.printWinner(CarsDto(cars.getWinner()))
    }
}
