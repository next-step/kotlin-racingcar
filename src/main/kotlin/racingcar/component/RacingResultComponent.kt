package racingcar.component

import racingcar.store.CarGroupStore
import racingcar.store.RoundStore
import racingcar.ui.Br

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
