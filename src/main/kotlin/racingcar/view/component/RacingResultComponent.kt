package racingcar.view.component

import racingcar.view.store.CarGroupStore
import racingcar.view.store.RoundStore

class RacingResultComponent : Component {
    override fun render() {
        val carGroup = CarGroupStore.getState()
        val rounds = RoundStore.getState()

        rounds.forEach { round -> RoundComponent(round = round).render() }
        val winners = carGroup.getWinners()
        WinnerComponent(winners = winners).render()
    }
}
