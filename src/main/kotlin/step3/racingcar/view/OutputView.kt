package step3.racingcar.view

object OutputView {
    fun printRequestCarCount() {
        println(Messages.MESSAGE_REQUEST_CAR_COUNT)
    }

    fun printRequestAttemptCount() {
        println(Messages.MESSAGE_REQUEST_ATTEMPT_COUNT)
    }

    fun printExecutionResult() {
        println(Messages.MESSAGE_EXECUTION_RESULT)
    }

    fun printPosition(position: Int) {
        println("-".repeat(position))
    }

    fun print() {
        println()
    }
}
