package racingcar.ui

class ResultView {

    fun draw(position: Int) = "-".repeat(position)

    fun getFinishStepTitle(step: Int) = "Finish ${step + 1} Step"

    fun showMessage(message: String) = println(message)

    companion object {
        const val TITLE_RACING_RESULT = "Execution result"
    }
}
