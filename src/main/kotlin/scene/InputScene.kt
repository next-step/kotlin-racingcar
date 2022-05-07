package scene

import dto.InputResult
import gameobj.StandardInputSystem
import port.OutputPainter

class InputScene(private val outputPainter: OutputPainter, private val inputSystem: StandardInputSystem) {

    fun update(): InputResult {
        outputPainter.draw("라운드 입력> ")
        val round = inputSystem.read().toInt()
        outputPainter.draw("플레이어 수 입력> ")
        val player = inputSystem.read().toInt()
        return InputResult(round, player)
    }
}
