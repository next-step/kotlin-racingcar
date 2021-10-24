package racingcar.ui

import racingcar.domain.BulletinBoard
import racingcar.domain.Names
import racingcar.domain.Records
import racingcar.domain.Record
import java.lang.StringBuilder

class RacingCarScoreView {

    fun display(board: BulletinBoard): String {
        val result = StringBuilder()
        board.scores.forEach { result.append(record(it.value)).append(LINE_FEED).append(LINE_FEED) }
        return result.toString()
    }

    fun showWinner(names: Names): String {
        return names.values.joinToString { it.value }
    }

    private fun record(records: Records): String {
        return records.values.joinToString(LINE_FEED) { calculate(it) }
    }

    private fun calculate(record: Record): String {
        return "${record.name.value} : ${RACING_CAR_EMOJI.repeat(record.score)}"
    }

    companion object {
        private const val RACING_CAR_EMOJI = "🚘"
    }
}
