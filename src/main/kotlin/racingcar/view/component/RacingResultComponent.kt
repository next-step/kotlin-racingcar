package racingcar.view.component

import racingcar.view.container.WinnerContainer
import racingcar.view.store.RoundStore

class RacingResultComponent : Component {
    override fun render() {
        val rounds = RoundStore.getState()
        rounds.forEach { round -> RoundComponent(round = round).render() }
        WinnerContainer().render()
    }
}
