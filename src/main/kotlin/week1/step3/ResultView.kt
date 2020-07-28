package week1.step3

object ResultView {

    fun printRacingStep(carNames: List<String>, racingStep: List<Int>) {
        for (position in racingStep.indices) {
            printCarName(carNames, position)
            printCarForwardState(racingStep, position)
            printNewline(position, carNames)
        }
        printWinner(racingStep, carNames)
    }

    private fun printWinner(racingStep: List<Int>, carNames: List<String>) {
        val finalRound = racingStep.subList(racingStep.lastIndex - carNames.lastIndex, racingStep.size)
        val winners = mutableListOf<String>()
        for (index in finalRound.indices) {
            if (finalRound[index] == finalRound.max()) {
                winners.add(carNames[index])
            }
        }
        println("${winners.joinToString()}가 최종 우승했습니다.")
    }

    private fun printNewline(index: Int, carNames: List<String>) {
        if ((index + 1) % carNames.size == 0) {
            println()
        }
    }

    private fun printCarForwardState(racingStep: List<Int>, position: Int) {
        repeat(racingStep[position]) {
            print("-")
        }
        println()
    }

    private fun printCarName(carNames: List<String>, position: Int) {
        print("${carNames[position % carNames.size]} : ")
    }
}
