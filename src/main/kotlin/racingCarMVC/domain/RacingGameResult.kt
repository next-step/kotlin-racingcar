package racingCarMVC.domain

import racingCarMVC.domain.dto.GameRecord

class RacingGameResult(
    private val gameRecords: List<GameRecord>
) {
    fun getWinners(): List<String> {
        return gameRecords.filter { it.position == this.getMaxPosition() }
            .map { it.name }
    }

    private fun getMaxPosition(): Int {
        return gameRecords.maxOf { it.position }
    }
}
