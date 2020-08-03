import carracing.CarRacing
import carracing.InputView
import carracing.ResultView

fun main() {

    try {
        val carNames: String = InputView.getCarNames()
        val count: Int = InputView.getCount()

        val carRacing = CarRacing(carNames, count)

        while (carRacing.isRacing()){
            val cars = carRacing.race()
            ResultView.showCarMovement(cars)
        }

        val winners = carRacing.findWinners()
        ResultView.showWinners(winners)

    } catch (e: Exception) {
        println(e.message)
    }
}
