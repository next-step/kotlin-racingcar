package racing

import racing.domain.CarsFactory
import racing.domain.RandomEngine

fun main() {
    val controller = CarsController(CarsFactory(RandomEngine))
    controller.play()
}
