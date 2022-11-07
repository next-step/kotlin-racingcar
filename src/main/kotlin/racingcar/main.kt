import racingcar.service.RacingService
import racingcar.view.InputView
import racingcar.view.ResultView

private const val ONE = 1

fun main() {
    val inputView = InputView()
    val resultView = ResultView()
    val racingService = RacingService()

    val carCount = inputView.getCarCount()
    val tryCount = inputView.getTryCount()

    var cars = racingService.makeCar(carCount)
    (ONE..tryCount).forEach { _ ->
        var movedCars = racingService.race(cars)
        resultView.printCarDistance(movedCars)
        cars = movedCars
    }
}
