package racingcar.view.container

import racingcar.view.component.RoundComponent
import racingcar.view.store.RoundStore

class RoundContainer : Container {
    override fun render() {
        val rounds = RoundStore.getState()
        rounds.forEach { round -> RoundComponent(round = round).render() }
    }
}
