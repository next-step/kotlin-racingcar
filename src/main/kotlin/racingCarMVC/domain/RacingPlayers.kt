package racingCarMVC.domain

import racingCarMVC.domain.dto.Player

class RacingPlayers(
    private val players: List<Player>
) {
    fun getWinners(): List<String> {
        return players.filter { it.position == this.getMaxPosition() }
            .map { it.name }
    }

    private fun getMaxPosition(): Int {
        return players.maxOf { it.position }
    }
}