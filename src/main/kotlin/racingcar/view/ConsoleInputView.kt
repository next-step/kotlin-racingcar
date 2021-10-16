package racingcar.view

import racingcar.model.CarCount
import racingcar.model.GameCount
import util.toIntOrThrow

class ConsoleInputView : InputView {

    override fun getCarCount(): CarCount {
        println("자동차 대수는 몇 대인가요?")
        val count = readLine().toIntOrThrow()

        return CarCount(count)
    }

    override fun getGameCount(): GameCount {
        println("시도할 횟수는 몇 회인가요?")
        val count = readLine().toIntOrThrow()

        return GameCount(count)
    }
}
