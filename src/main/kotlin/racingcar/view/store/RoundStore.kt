package racingcar.view.store

import racingcar.domain.Round

object RoundStore : Store<List<Round>>() {
    private var rounds = listOf<Round>()

    override fun getState(): List<Round> {
        return this.rounds
    }

    override fun setState(state: List<Round>) {
        this.rounds = state
        this.listeners.forEach { listener -> listener() }
    }

    override fun subscribe(listener: Listener): UnSubscribe {
        this.listeners.add(listener)
        return { this.listeners.remove(listener) }
    }
}
