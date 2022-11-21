package racingcar.view.container

import racingcar.view.store.RoundStore

class RoundListContainer : Container {
    override fun render() {
        val rounds = RoundStore.getState()
        rounds.forEach {
            RoundContainer(round = it).render()
        }
    }
}
