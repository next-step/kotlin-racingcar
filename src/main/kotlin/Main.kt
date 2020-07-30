import wk1_step4.WinnerCarRacing
import wk1_step4.WinnerCarRacingView

fun main() {

    try {
        val carNamesInput = WinnerCarRacingView.getCarNames()
        WinnerCarRacingView.checkCarsValidation(carNamesInput)

        val countInput = WinnerCarRacingView.getCount()
        val count: Int = WinnerCarRacingView.checkCountValidation(countInput)

        val winnerCarRacing = WinnerCarRacing(carNamesInput)

        for (i in 1..count) {
            WinnerCarRacingView.showCarMovement(winnerCarRacing.updateCarRacing())
        }

        WinnerCarRacingView.showResult(winnerCarRacing.findWinners())
    } catch (e: Exception) {
        println(e.message)
    }
}
