package racingcar.assemble

import racingcar.application.race.Race
import racingcar.application.race.factory.CarFactory
import racingcar.domain.car.engine.implement.RandomMovingEngine
import racingcar.interfaces.ui.controller.RacingCarController

object ObjectAssemble {
    fun start() = racingCarController().startRace()

    private fun racingCarController() = RacingCarController(race = race())
    private fun race() = Race(carFactory = carFactory())
    private fun carFactory() = CarFactory(movingEngine = movingEngine())
    private fun movingEngine() = RandomMovingEngine()
}
