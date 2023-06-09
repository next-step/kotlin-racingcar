package race

class CarRaceResultView {
    fun printRaceResult(raceResult: RaceResult) {
        println("\n실행 결과")
        raceResult.turns
            .filter { it !is InitialTurn }
            .forEach { it.print() }
    }

    private fun TurnInfo.print() {
        cars.print()
        println()
    }

    private fun List<Car>.print() {
        forEach { it.print() }
    }

    private fun Car.print() {
        println("-".repeat(position))
    }
}
