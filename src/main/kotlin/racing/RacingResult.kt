package racing

class RacingResult {
    fun showRacingResult(racingRoundResults: List<List<Int>>) {
        racingRoundResults.forEachIndexed { index, racingResult ->
            println("${index + FIXED_INDEX}회차 경주")
            printRacingResult(racingResult)
            println()
        }
    }

    private fun printRacingResult(singleRoundResults: List<Int>) {
        singleRoundResults.forEach {
            println("-".repeat(it))
        }
    }

    companion object {
        const val FIXED_INDEX = 1
    }
}
