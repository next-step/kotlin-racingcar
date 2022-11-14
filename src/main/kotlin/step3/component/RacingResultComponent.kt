package step3.component

import step3.CarStore
import step3.RoundStore
import step3.ui.Br

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
    }
}
