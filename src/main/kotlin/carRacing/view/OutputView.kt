package carRacing.view

import carRacing.model.CarRecord
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

    private fun renderCarPosition(car: CarRecord, printer: Print) {
        printer.print("${car.name} : ")
        repeat(car.curPosition) { printer.print("-") }
        printer.print("\n")
    }

    private fun renderRound(round: Int, CarRecord: List<CarRecord>, printer: Print) {
        printer.println("<-------------- $round Round Race 🏎️ -------------->")
        for (car in CarRecord) {
            renderCarPosition(car, printer)
        }
    }

    private fun renderWinner(results: List<RaceResult>, printer: Print) {
        val lastCarStatus = results.last().CarRecord
        val max = lastCarStatus.maxOfOrNull { it.curPosition }
        val winner = lastCarStatus.filter{it.curPosition == max}
        printer.println("우승자는 ${winner.fold(""){ acc, it -> "${it.name} $acc"}}")
    }

    fun renderRace(raceResults: List<RaceResult>, printer: Print) {
        raceResults.forEach { renderRound(round = it.round, CarRecord = it.CarRecord, printer) }
        renderWinner(raceResults, printer)
    }


}
