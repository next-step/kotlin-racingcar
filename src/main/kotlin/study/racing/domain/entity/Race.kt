package study.racing.domain.entity

import study.racing.domain.repository.RoundRepositoryImpl

class Race(
    roundCount: Int,
    cars: List<RacingCar>,
) {
    val rounds: List<Round> = List(roundCount) { Round(RoundRepositoryImpl(), cars) }

    fun start() {
        rounds.forEach(Round::race)
    }

    fun getWinner(): List<Record> = rounds
        .lastOrNull()
        ?.getWinner()
        ?: throw IllegalStateException("아직 우승자가 결정되지 않았습니다.")
}