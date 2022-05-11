package scene

import port.InputSystem
import port.OutputPainter

class InputScene(private val outputPainter: OutputPainter, private val inputSystem: InputSystem) : Scene() {

    override fun before() {
    }

    override fun update() {
        getCarNumber()
        getStageNumber()
    }

    override fun after() {
        outputPainter.draw("\n실행 결과\n")
    }

    private fun getCarNumber() {
        outputPainter.draw("자동차 대수는 몇 대인가요?\n")
        setPlayer(inputSystem.read().toInt())
    }

    private fun getStageNumber() {
        outputPainter.draw("시도할 횟수는 몇 회인가요?\n")
        setStage(inputSystem.read().toInt())
    }

    override fun hasNext(): Boolean = false
}
