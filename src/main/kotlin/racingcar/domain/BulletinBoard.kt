package racingcar.domain

import racingcar.ui.LINE_FEED
import java.lang.StringBuilder

class BulletinBoard(private val board: Map<Lap, Records> = mapOf(), val winners: Names = Names.of()) {

    fun record(participants: RacingCars, lap: Lap): BulletinBoard {
        val temp = board.toMutableMap()
        temp[lap] = Records.of(participants)
        return BulletinBoard(temp, calculateWinner(participants))
    }

    private fun calculateWinner(participants: RacingCars): Names {
        val max = participants.list.maxOf { it.position.value }
        return Names.of(participants.list.filter { it.position.value == max }.map { it.name.value })
    }

    fun display(): String {
        val result = StringBuilder()
        board.forEach { result.append(it.value.display()).append(LINE_FEED).append(LINE_FEED) }
        return result.toString()
    }
}
