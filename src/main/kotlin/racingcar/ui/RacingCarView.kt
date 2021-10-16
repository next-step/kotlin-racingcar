package racingcar.ui

import racingcar.dto.ScoreboardConsoleDto

interface RacingCarView {
    fun requireInput(method: () -> Unit): String? {
        method()
        return readLine()
    }
    fun carCount(): String?
    fun lapCount(): String?
    fun showResult(dto: ScoreboardConsoleDto)
}
