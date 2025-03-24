package carracing

class OutputView(val outputViewResolver: OutputViewResolver) {
    fun printRaceResult(positions: List<Int>) {
        val raceResult = outputViewResolver.makeCarPositionsView(positions)
        println(raceResult)
    }
}
