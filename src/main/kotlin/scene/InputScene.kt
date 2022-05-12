package scene

import engine.EnvironmentManager
import port.InputSystem
import port.OutputPainter

class InputScene(private val outputPainter: OutputPainter, private val inputSystem: InputSystem) : Scene {

    override fun before() {
    }

    override fun update() {
        getCarNumber()
        getStageNumber()
    }

    override fun after() {
    }

    private fun getCarNumber() {
        outputPainter.draw("자동차 대수는 몇 대인가요?\n")
        EnvironmentManager.put("CAR_NUMBER", inputSystem.read())
    }

    private fun getStageNumber() {
        outputPainter.draw("시도할 횟수는 몇 회인가요?\n")
        EnvironmentManager.put("STAGE_NUMBER", inputSystem.read())
    }

    override fun hasNext(): Boolean = false
}
