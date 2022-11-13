package racing.domain

import racing.enumeration.RacingGameStatus
import java.util.UUID

class RacingGame(
    val id: RacingGameId,
    val participants: List<RacingCar>,
    val round: Int,
) {
    var status: RacingGameStatus = RacingGameStatus.READY
        private set

    companion object {
        fun create(participants: List<RacingCar>, round: Int): RacingGame {
            val uuid = UUID.randomUUID().toString()
            val racingGameId = RacingGameId(uuid)
            return RacingGame(
                id = racingGameId,
                participants = participants,
                round = round,
            )
        }
    }

    fun play() {
        if (this.status != RacingGameStatus.READY) {
            throw IllegalStateException("레이싱 경주를 시작할 수 없는 상태입니다. currentStatus = $status")
        }
        status = RacingGameStatus.RACING
        for (currentRound in 1..this.round) {
            playRound()
        }

        status = RacingGameStatus.FINISH
    }

    private fun playRound() {
        this.participants.forEach { it.moveForward() }
    }
}

@JvmInline
value class RacingGameId(
    val value: String
)
