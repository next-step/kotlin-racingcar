import wk1_step4.Car
import wk1_step4.WinnerCarRacing
import wk1_step4.WinnerCarRacingView
import java.lang.Exception

fun main() {

    try {
        WinnerCarRacingView.showFirstInstruction()
        val firstInput = readLine()!!
        val cars: List<Car> = WinnerCarRacingView.parsingCars(firstInput)

        WinnerCarRacingView.showSecondInstruction()
        val count: Int = WinnerCarRacingView.checkCountValidation(readLine()!!)

        for (i in 1..count) {
            WinnerCarRacing.updateCarRacing(cars)
            WinnerCarRacingView.showCarMovement(cars)
        }

        val winners: List<Car> = WinnerCarRacing.resultOfRacing(cars)
        WinnerCarRacingView.showResult(winners)
    } catch (e: Exception) {
        println(e.message)
    }
}
