package racingcar.view.store

import racingcar.domain.Round

object RoundStore : Store<List<Round>> {
    private var rounds = listOf<Round>()

    override fun getState(): List<Round> {
        return rounds
    }

    override fun setState(state: List<Round>) {
        rounds = state
    }
}
