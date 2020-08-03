import carracing.CarRacing
import carracing.InputView
import carracing.ResultView

fun main() {

    try {
        val carNames: String = InputView.getCarNames()
        val carRacing = CarRacing(carNames, 0)

        val count: Int = InputView.getCount()

        println()
        for (i in 1..count) {
            carRacing.execute()
            ResultView.showCarMovement(carRacing.cars)
            println()
        }
        ResultView.showWinners(carRacing.findWinners())
    } catch (e: Exception) {
        println(e.message)
    }
}
