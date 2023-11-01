package racingcar

import racingcar.controller.CarController
import racingcar.model.creator.RandomEngineCarCreator

fun main() {
    val carController = CarController(RandomEngineCarCreator)
    carController.run()
}
