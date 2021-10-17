package racingcar.view

import racingcar.model.CarName
import racingcar.model.GameCount
import util.toIntOrThrow

class ConsoleInputView(
    private val carNameDelimiter: String = ","
) : InputView {

    override fun getCarNames(): List<CarName> {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")

        val carNames = readLine() ?: return emptyList()
        return carNames
            .split(carNameDelimiter)
            .asSequence()
            .filter { it.isNotBlank() }
            .map { name -> CarName(name.trim()) }
            .toList()
    }

    override fun getGameCount(): GameCount {
        println("시도할 횟수는 몇 회인가요?")
        val count = readLine().toIntOrThrow()

        return GameCount(count)
    }
}
