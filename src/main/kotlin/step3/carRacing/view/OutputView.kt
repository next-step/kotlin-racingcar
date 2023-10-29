package step3.carRacing.view

import step3.carRacing.model.Car
import step3.carRacing.model.CarData
import step3.carRacing.model.RaceResult

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
