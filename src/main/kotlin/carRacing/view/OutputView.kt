package carRacing.view

import carRacing.model.CarData
import carRacing.model.RaceResult


interface Print {
    fun print(string: String)
    fun println(string: String)
}

object SystemPrint : Print {
    override fun print(string: String) {
        kotlin.io.print(string)
    }

    override fun println(string: String) {
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

    private fun renderRound(round: Int, carData: List<CarData>, printer: Print) {
        printer.println("<-------------- $round Round Race 🏎️ -------------->")
        for (car in carData) {
            renderCarPosition(car, printer)
        }
    }

    private fun renderWinner(results: List<RaceResult>, printer: Print) {
        val lastCarData = results.last().carData
        val max = lastCarData.maxOfOrNull { it.curPosition }
        val winner = lastCarData.filter{it.curPosition == max}
        printer.println("우승자는 ${winner.fold(""){ acc, it -> "${it.name} $acc"}}")
    }

    fun renderRace(raceResults: List<RaceResult>, printer: Print) {
        raceResults.forEach { renderRound(round = it.round, carData = it.carData, printer) }
        renderWinner(raceResults, printer)
    }


}
