package carracing.game.controller

import carracing.game.domain.InputValidator
import carracing.game.domain.data.Race
import carracing.game.view.ErrorView
import carracing.game.view.InputView

class RaceParametersController(
    private val inputView: InputView = InputView(),
    private val errorView: ErrorView = ErrorView(),
    private val inputValidator: InputValidator = InputValidator,
) {
    fun setRaceParameters(): Race {
        val carNames = getCarsParameter()
        val rounds = getRoundsParameter()
        return Race(carsNames = carNames, totalRounds = rounds)
    }

    private fun getCarsParameter(): List<String> {
        while (true) {
            try {
                return inputValidator.validateCarNames(inputView.inquireCarsNames())
            } catch (e: IllegalArgumentException) {
                e.message?.let { errorView.printError(it) }
            }
        }
    }

    private fun getRoundsParameter(): Int {
        while (true) {
            try {
                return inputValidator.validateRoundsAmount(inputView.inquireRoundsAmount())
            } catch (e: IllegalArgumentException) {
                e.message?.let { errorView.printError(it) }
            }
        }
    }
}
