import carracing.CarRacing
import carracing.CarRacingView

fun main() {

    try {
        val carNames: String = CarRacingView.getCarNames()
        val carRacing = CarRacing(carNames, 0)

        val count: Int = CarRacingView.getCount()

        println()
        for (i in 1..count) {
            carRacing.execute()
            CarRacingView.showCarMovement(carRacing.cars)
            println()
        }
        CarRacingView.showWinners(carRacing.findWinners())
    } catch (e: Exception) {
        println(e.message)
    }
}
