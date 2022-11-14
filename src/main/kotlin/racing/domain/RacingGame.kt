package racing.domain

import racing.dto.RacingGameInfo

class RacingGame(
    val participants: List<RacingCar>,
    val rounds: List<Round>,
) {
    companion object {
        fun create(numberOfCar: Int, totalRound: Int): RacingGame {
            val participants = RacingCar.create(numberOfCar)
            val rounds = buildList {
                for (id in 1..totalRound) {
                    this.add(Round(id, participants))
                }
            }
            return RacingGame(
                participants = participants,
                rounds = rounds
            )
        }
    }

    fun play(): RacingGameInfo {
        val roundInfos = rounds.map { it.race() }
        return RacingGameInfo(roundInfos)
    }
}
