package scene

import engine.EnvironmentManager
import port.InputSystem
import port.OutputPainter
import utils.Constants

class InputScene(
    private val outputPainter: OutputPainter,
    private val inputSystem: InputSystem,
    private val environmentManager: EnvironmentManager,
) : Scene {

    override fun update() {
        getCarNumber()
        getStageNumber()
    }

    private fun getCarNumber() {
        outputPainter.draw("자동차 대수는 몇 대인가요?\n")
        environmentManager.put(Constants.CAR_NUMBER_KEY, inputSystem.read())
    }

    private fun getStageNumber() {
        outputPainter.draw("시도할 횟수는 몇 회인가요?\n")
        environmentManager.put(Constants.STAGE_NUMBER_KEY, inputSystem.read())
    }

    override fun hasNext(): Boolean = false
}
