package racingcar.store

import racingcar.Round

object RoundStore : Store<List<Round>> {
    private var rounds = listOf<Round>()

    override fun getState(): List<Round> {
        return rounds
    }

    override fun setState(state: List<Round>): List<Round> {
        rounds = state
        return rounds
    }
}
