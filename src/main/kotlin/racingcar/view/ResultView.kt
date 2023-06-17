package racingcar.view

object ResultView {
    private const val PROGRESS_STRING = "-"

    fun showRacingStage(carProgresses: List<Int>) {
        carProgresses.forEach {
            showProgress(it)
        }
        println()
    }

    private fun showProgress(progress: Int) {
        println(PROGRESS_STRING.repeat(progress))
        println()
    }
}
