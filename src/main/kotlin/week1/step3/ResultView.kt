package week1.step3

object ResultView {

    fun printRacingStep(carNames: List<String>, racingStep: List<Int>) {
        for (position in racingStep.indices) {
            printCarName(carNames, position)
            printCarForwardState(racingStep, position)
            printNewline(position, carNames)
        }
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
