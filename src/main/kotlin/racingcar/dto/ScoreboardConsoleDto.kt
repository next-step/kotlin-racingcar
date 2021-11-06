package racingcar.dto

import racingcar.domain.RacingCar
import racingcar.domain.RacingCars
import racingcar.domain.vo.Lap
import racingcar.domain.vo.Scoreboard

private const val POSITION_CHARACTER = "-"

data class ScoreboardConsoleDto(
    private val scoreboard: Scoreboard,
) {
    val result: String = showSnapshots()
        .map { it.toList() }
        .joinToString(
            separator = System.lineSeparator().repeat(2)
        ) { it.stringifyPosition() }

    private fun showSnapshots(): List<RacingCars> = scoreboard.laps()
        .toList()
        .map { showSnapshotOf(it) }

    private fun showSnapshotOf(lap: Lap): RacingCars = scoreboard.snapshotOf(lap)

    private fun List<RacingCar>.stringifyPosition(): String = this.joinToString(
        separator = System.lineSeparator()
    ) { POSITION_CHARACTER.repeat(it.position.value) }
}
