package racingcar.view

object ResultView {
    private const val PROGRESS_STRING = "-"

    fun showRacingStage(carProgress: List<Int>) {
        carProgress.forEach {
            showProgress(it)
        }
        println()
    }

    private fun showProgress(progress: Int) {
        repeat(progress) {
            print(PROGRESS_STRING)
        }
        println()
    }
}
