import step3_racingcar.service.RacingService
import step3_racingcar.view.InputView
import step3_racingcar.view.ResultView

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
