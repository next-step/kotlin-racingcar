package racingcar.view.component

import racingcar.view.store.CarGroupStore
import racingcar.view.store.RoundStore
import racingcar.view.ui.Br

class RacingResultComponent : Component {
    override fun render() {
        val carGroup = CarGroupStore.getState()
        val rounds = RoundStore.getState()

        rounds.forEach { round ->
            val roundResult = round.start(carGroup = carGroup)
            RoundOrderComponent(id = round.id).render()
            RoundResultComponent(roundResult = roundResult).render()
            Br().draw()
            Thread.sleep(1000)
        }
        val winners = carGroup.getWinners()
        WinnerComponent(winners = winners).render()
    }
}
