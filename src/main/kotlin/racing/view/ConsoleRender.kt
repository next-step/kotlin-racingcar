package racing.view

import racing.model.RacingHistory

class ConsoleRender {
    companion object {
        fun consolePresent(racingHistory: RacingHistory): String {
            return racingHistory.result
                .map { "-".repeat(it.position) }
                .joinToString(separator = "\n")
        }
    }
}
