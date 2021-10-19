package racingcar.view.input

import racingcar.domain.CarNames
import racingcar.domain.NumberOfTrials

class ConsoleInputView : InputView {
    override fun getCarNames(): CarNames {
        println(RECEIVE_CAR_NAMES_MESSAGE)
        return CarNames.from(readLine())
    }

    override fun getNumberOfTrials(): NumberOfTrials {
        println(RECEIVE_NUMBER_OF_TRIALS_MESSAGE)
        return NumberOfTrials.from(readLine()?.toIntOrNull())
    }

    companion object {
        private const val RECEIVE_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
        private const val RECEIVE_NUMBER_OF_TRIALS_MESSAGE = "시도할 횟수는 몇 회인가요? (1이상 20이하 숫자 입력)"
    }
}
