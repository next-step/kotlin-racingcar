package racingcar.ui

import racingcar.dto.ScoreboardConsoleDto

interface RacingCarView {
    fun requireInput(method: () -> Unit): String? {
        method()
        return readLine()
    }
    fun carNames(): String?
    fun lapCount(): String?
    fun showResult(dto: ScoreboardConsoleDto)
}
