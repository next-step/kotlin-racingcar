package carracing

import carracing.domain.Car
import carracing.domain.Cars
import carracing.domain.Name
import carracing.domain.Winners
import carracing.view.InputView
import carracing.view.OutputView

fun main() {

    val carNames = InputView.inputCarNames()
    val attemptCount = InputView.getAttemptCount()

    val cars = makeCars(carNames)
    OutputView.printRacingCar(cars, attemptCount)

    val winners = Winners(cars).getWinners()
    OutputView.racingResult(winners)
}
fun makeCars(names: String): Cars{
    return Cars(names.split(",").map { Car(Name(it)) })
}
