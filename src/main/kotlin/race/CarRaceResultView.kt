package race

class CarRaceResultView {
    fun printCurrentState(raceResult: RaceResult) {
        println("\n실행 결과")
        raceResult.positions
            .forEach {
                it.positions.forEach {
                    println("-".repeat(it.position))
                }
                println()
            }
    }
}
