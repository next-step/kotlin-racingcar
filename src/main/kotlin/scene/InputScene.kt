package scene

import dto.InputResult
import port.InputSystem
import port.OutputPainter

class InputScene(private val outputPainter: OutputPainter, private val inputSystem: InputSystem) {

    fun update(): InputResult {
        return InputResult(getCarNumber(), getStageNumber())
    }

    private fun getCarNumber(): Int {
        outputPainter.draw("자동차 대수는 몇 대인가요?\n")
        return inputSystem.read().toInt()
    }

    private fun getStageNumber(): Int {
        outputPainter.draw("시도할 횟수는 몇 회인가요?\n")
        return inputSystem.read().toInt()
    }
}
