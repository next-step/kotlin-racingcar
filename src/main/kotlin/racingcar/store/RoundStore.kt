package racingcar.store

import racingcar.Round

object RoundStore : Store<Round> {
    private var rounds = listOf<Round>()

    override fun findAll(): List<Round> {
        return rounds
    }

    override fun saveAll(list: List<Round>): List<Round> {
        rounds = list
        return rounds
    }
}
