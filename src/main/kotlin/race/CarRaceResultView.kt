package race

class CarRaceResultView {
    fun printRaceResult(raceResult: RaceResult) {
        println("\n실행 결과")
        raceResult.turns
            .filter { it !is InitialTurn }
            .forEach {
                it.carPositions.forEach {
                    println("-".repeat(it.position))
                }
                println()
            }
    }
}
