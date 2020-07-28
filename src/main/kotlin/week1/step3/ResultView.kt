package week1.step3

object ResultView {

    fun printRacingStep(racingCarCount: Int, racingStep: List<Int>) {
        for (step in racingStep.indices) {
            repeat(racingStep[step]) {
                print("-")
            }
            println()
            if ((step + 1) % racingCarCount == 0) {
                println()
            }
        }
    }
}
