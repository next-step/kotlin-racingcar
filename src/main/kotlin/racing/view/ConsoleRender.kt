package racing.view

import racing.model.MatchResult

class ConsoleRender {
    fun consolePresent(matchResult: MatchResult): String {
        return matchResult.result
            .map { "-".repeat(it.position) }
            .joinToString(separator = "\n")
    }
}
