package step3.component

import step3.CarStore
import step3.RoundStore

class RacingResultComponent : Component {
    override fun render() {
        val cars = CarStore.findAll()
        val rounds = RoundStore.findAll()

        rounds.forEach { round ->
            val roundResult = round.start(cars = cars)
            RoundResultComponent(roundResult = roundResult).render()
            Thread.sleep(1000)
            println()
        }
    }
}
