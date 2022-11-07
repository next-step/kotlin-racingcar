package racingcar.assemble

import racingcar.application.port.`in`.InputPort
import racingcar.application.port.out.OutputPort
import racingcar.application.race.Race
import racingcar.application.race.factory.CarFactory
import racingcar.domain.car.engine.implement.RandomMovingEngine
import racingcar.interfaces.ui.input.RacingCarInputAdapter
import racingcar.interfaces.ui.output.RacingCarOutputAdapter

object ObjectAssemble {
    fun start() = racingCarInputAdapter().input()
    private fun racingCarInputAdapter() = RacingCarInputAdapter(inputPort = inputPort())
    private fun inputPort() = InputPort(race = race())

    private fun race() = Race(outputPort = outputPort(), carFactory = carFactory())
    private fun carFactory() = CarFactory(movingEngine = movingEngine())
    private fun movingEngine() = RandomMovingEngine()

    private fun outputPort() = OutputPort(racingCarOutputAdapter = racingCarOutputAdapter())
    private fun racingCarOutputAdapter() = RacingCarOutputAdapter()
}
