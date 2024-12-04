package racing.view.input

import racing.model.InputValidator

internal class ConsoleInputView : InputView {
    override fun inputCarNames(): List<String> {
        val input = readlnOrNull()
        val validatedInput = InputValidator.requireValidCarNamesInput(input)
        return splitCarNames(validatedInput)
    }

    private fun splitCarNames(input: String): List<String> {
        return input.split(DELIMITER_COMMA).map { it.trim() }
    }

    override fun inputAttemptCount(): Int {
        val input = readlnOrNull()
        val validatedAttemptCount = InputValidator.requireValidAttemptCountInput(input).toInt()
        return validatedAttemptCount
    }

    companion object {
        const val DELIMITER_COMMA = ','
        const val DEFAULT_NAME_MAX = 5
    }
}
