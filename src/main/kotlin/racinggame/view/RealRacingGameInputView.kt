package racinggame.view

import racinggame.domain.car.CarName

class RealRacingGameInputView : RacingGameInputView {

    override fun readRacingGameInput(): Result<RacingGameInput> {
        return runCatching {
            val carNames = receiveCarNamesOrNull() ?: run {
                println(FINISH_WITH_INVALID_NAME)
                throw IllegalArgumentException("inputted invalid car names")
            }
            val playCount = receiveGamePlayCountOrNull() ?: run {
                println(FINISH_WITH_NOT_POSITIVE_INTEGER)
                throw IllegalArgumentException("inputted invalid game play count")
            }

            RacingGameInput(
                carNames = carNames,
                gamePlayCount = playCount,
            )
        }
    }

    private fun receiveCarNamesOrNull(): List<CarName>? {
        println(INPUT_CAR_NAMES_MESSAGE)
        return readlnOrNull().orEmpty()
            .split(USER_NAMES_DELIMITER)
            .let { inputNames -> runCatching { inputNames.toCarNames() } }
            .getOrNull()
            ?.takeIf { carNames -> carNames.isNotEmpty() }
    }

    private fun receiveGamePlayCountOrNull(): Int? {
        println(INPUT_GAME_PLAY_COUNT_MESSAGE)
        return readlnOrNull()
            ?.toIntOrNull()
            ?.takeIf { it > 0 }
    }

    private fun List<String>.toCarNames(): List<CarName> {
        return map { name -> CarName(name) }
    }

    companion object {
        private const val INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
        private const val FINISH_WITH_INVALID_NAME = "경주할 자동차 이름 입력에 오류가 있습니다. (최소 1개, 공백 x, 최대 5자 이내)"
        private const val INPUT_GAME_PLAY_COUNT_MESSAGE = "시도할 횟수는 몇 회인가요?"
        private const val FINISH_WITH_NOT_POSITIVE_INTEGER = "양의 정수를 입력하지 않아 프로그램을 종료합니다."
        private const val USER_NAMES_DELIMITER = ","
    }
}
