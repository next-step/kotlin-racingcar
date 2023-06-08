package race

class CarRaceResultView {
    fun printCurrentState(raceResult: RaceResult) {
        println("\n실행 결과")
        raceResult.turns
            .forEach {
                it.carPositions.forEach {
                    println("-".repeat(it.position))
                }
                println()
            }
    }
}
