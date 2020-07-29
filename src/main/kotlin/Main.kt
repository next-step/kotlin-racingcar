import wk1_step4.WinnerCarRacing
import wk1_step4.WinnerCarRacingView

fun main() {

    try {
        val firstInput = WinnerCarRacingView.getCarNames()
        WinnerCarRacingView.checkCarsValidation(firstInput)

        val secondInput = WinnerCarRacingView.getCount()
        val count: Int = WinnerCarRacingView.checkCountValidation(secondInput)

        val winnerCarRacing = WinnerCarRacing(firstInput)

        for (i in 1..count) {
            WinnerCarRacingView.showCarMovement(winnerCarRacing.updateCarRacing())
        }

        WinnerCarRacingView.showResult(winnerCarRacing.findWinners())
    } catch (e: Exception) {
        println(e.message)
    }
}
