package step4.carRacingWinner.view

import step4.carRacingWinner.model.CarData
import step4.carRacingWinner.model.RaceResult


interface Print {
    fun print(string:String)
    fun println(string:String)
}

object SystemPrint: Print{
    override fun print(string:String) {
        kotlin.io.print(string)
    }

    override fun println(string:String) {
        kotlin.io.println(string)
    }
}

object OutputView {

    private fun renderCarPosition(car: CarData, printer: Print) {
        printer.print("${car.name} : ")
        for (position in 0 until car.curPosition) {
            printer.print("-")
        }
        printer.print("\n")
    }

    private fun renderRound(round: Int, carData: List<CarData>, printer:Print) {
        printer.println("<-------------- $round Round Race 🏎️ -------------->")
        for (car in carData) {
            renderCarPosition(car, printer)
        }
    }

    fun renderRace(raceResults:List<RaceResult>, printer: Print) {
        raceResults.forEach{renderRound(round = it.round, carData = it.carData, printer)}
    }


}
