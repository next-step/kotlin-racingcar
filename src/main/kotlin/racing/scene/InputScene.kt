package racing.scene

import racing.engine.EnvironmentManager
import racing.port.InputSystem
import racing.port.OutputPainter
import racing.utils.Constants

class InputScene(
    private val outputPainter: OutputPainter,
    private val inputSystem: InputSystem,
    private val environmentManager: EnvironmentManager,
) : Scene {

    override fun update() {
        setCarNumber()
        setStageNumber()
    }

    override fun hasNext(): Boolean = false

    private fun setCarNumber() {
        outputPainter.draw("자동차 대수는 몇 대인가요?\n")
        environmentManager.put(Constants.CAR_NUMBER_KEY, inputSystem.read())
    }

    private fun setStageNumber() {
        outputPainter.draw("시도할 횟수는 몇 회인가요?\n")
        environmentManager.put(Constants.STAGE_NUMBER_KEY, inputSystem.read())
    }
}
