package carRace

sealed interface RaceRegulationProvider {

    fun provide(): Pair<Int, Int>

    class Manual(private val carCount: Int, private val iterationCount: Int) : RaceRegulationProvider {
        override fun provide(): Pair<Int, Int> = Pair(carCount, iterationCount)
    }

    object UserInput : RaceRegulationProvider {
        override fun provide(): Pair<Int, Int> {
            val carCount = println("자동차 대수는 몇 대인가요?").run { readln().trim().toInt() }
            val iterationCount = println("시도할 횟수는 몇 회인가요?").run { readln().trim().toInt() }
            return Pair(carCount, iterationCount)
        }
    }
}
