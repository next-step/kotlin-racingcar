package study.step3.race

class DrawView(
    private val totalRaceCount: Int
) {
    init {
        println("실행 결과")
    }

    fun drawCarState(carStorage: IntArray, raceIdx: Int) {
        for (car in carStorage) {
            println("-".repeat(car))
        }

        if (totalRaceCount != raceIdx) println()
    }
}
