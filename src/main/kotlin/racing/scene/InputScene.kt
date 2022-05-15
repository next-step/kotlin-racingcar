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

    override fun run() {
        start()
    }

    private fun start() {
        setCarNumber()
        setStageNumber()
    }

    private fun setCarNumber() {
        outputPainter.draw("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)\n")
        environmentManager.put(Constants.CAR_NAMES_KEY, inputSystem.read())
    }

    private fun setStageNumber() {
        outputPainter.draw("시도할 횟수는 몇 회인가요?\n")
        environmentManager.put(Constants.STAGE_NUMBER_KEY, inputSystem.read())
    }
}
