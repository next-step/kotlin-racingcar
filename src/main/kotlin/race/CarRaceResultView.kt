package race

class CarRaceResultView {
    fun printRaceResult(raceResult: RaceResult) {
        println("\n실행 결과")
        raceResult.turns
            .filter { it !is InitialTurn }
            .forEach { it.print() }
    }

    private fun TurnInfo.print() {
        carPositions.print()
        println()
    }

    private fun List<CarPosition>.print() {
        forEach { it.print() }
    }

    private fun CarPosition.print() {
        println("-".repeat(position))
    }
}
