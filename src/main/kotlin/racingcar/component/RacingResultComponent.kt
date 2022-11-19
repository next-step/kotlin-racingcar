package racingcar.component

import racingcar.CarGroup
import racingcar.store.CarStore
import racingcar.store.RoundStore
import racingcar.ui.Br

class RacingResultComponent : Component {
    override fun render() {
        val cars = CarStore.findAll()
        val rounds = RoundStore.findAll()

        rounds.forEach { round ->
            val roundResult = round.start(carGroup = CarGroup(cars = cars))
            RoundOrderComponent(id = round.id).render()
            RoundResultComponent(roundResult = roundResult).render()
            Br().draw()
            Thread.sleep(1000)
        }
        WinnerComponent(cars = cars).render()
    }
}
