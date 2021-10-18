package racingcar.view

import racingcar.domain.Name
import racingcar.domain.Names

class InputView {

    companion object {
        private const val INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
        private const val CAR_NAME_DELIMITER = ","

        fun inputCarNames(): Names {
            println(INPUT_CAR_NAMES_MESSAGE)
            val carNames: List<String> = readLine()!!.split(CAR_NAME_DELIMITER)
            val names: List<Name> = carNames.map { Name(it) }
            return Names(names)
        }

        fun inputCounts(): Int {
            println("시도할 횟수는 몇 회인가요?")
            return readLine()!!.toInt()
        }
    }
}
