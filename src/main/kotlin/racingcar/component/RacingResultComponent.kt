package racingcar.component

import racingcar.CarStore
import racingcar.RoundStore
import racingcar.ui.Br

class RacingResultComponent : Component {
    override fun render() {
        val cars = CarStore.findAll()
        val rounds = RoundStore.findAll()

        rounds.forEach { round ->
            val roundResult = round.start(cars = cars)
            RoundOrderComponent(id = round.id).render()
            RoundResultComponent(roundResult = roundResult).render()
            Br().draw()
            Thread.sleep(1000)
        }
        WinnerComponent(cars = cars).render()
    }
}
