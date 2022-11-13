package step3.component

import step3.CarStore
import step3.RoundStore
import step3.ui.Br
import step3.ui.Span

class RacingResultComponent : Component {
    override fun render() {
        val cars = CarStore.findAll()
        val rounds = RoundStore.findAll()

        rounds.forEach { round ->
            val roundResult = round.start(cars = cars)
            Span(text = "${round.id} 라운드", block = true)
            RoundResultComponent(roundResult = roundResult).render()
            Thread.sleep(1000)
            Br().draw()
        }
    }
}
