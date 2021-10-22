package racingcar.domain

import racingcar.ui.LINE_FEED
import java.lang.StringBuilder

class BulletinBoard {
    private val board: MutableMap<Lap, Records> = LinkedHashMap()

    fun record(participants: RacingCars, lap: Lap) {
        board[lap] = Records.of(participants)
    }

    fun display(): String {
        val result = StringBuilder()
        board.forEach { result.append(it.value.display()).append(LINE_FEED) }
        return result.toString()
    }
}
