package racing.scene

import racing.dto.InputDto
import racing.port.InputSystem
import racing.port.OutputPainter

class InputScene(
    private val outputPainter: OutputPainter,
    private val inputSystem: InputSystem,
) {

    fun run(): InputDto = InputDto(getCarNames(), getRoundNumber())

    private fun getCarNames(): List<String> {
        outputPainter.draw("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)\n")
        return scanNames()
    }

    private fun scanNames(): List<String> =
        inputSystem
            .read()
            .split(",")
            .map(String::trim)

    private fun getRoundNumber(): Int {
        outputPainter.draw("시도할 횟수는 몇 회인가요?\n")
        return scanRoundNumber()
    }

    private fun scanRoundNumber() = inputSystem.read().toInt()
}
