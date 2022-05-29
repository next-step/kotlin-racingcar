package study.racingcar.view

class RacingView {

    companion object {
        private const val CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
        private const val ROUND_NUMBER_MESSAGE = "시도할 횟수는 몇 회인가요?"
        private const val RACE_RESULT_MESSAGE = "실행 결과"

        internal fun printRacingStart() {
            println(RACE_RESULT_MESSAGE)
        }

        internal fun printCarNameInputMessage() {
            println(CAR_NAME_INPUT_MESSAGE)
        }

        internal fun printRoundNumberMessage() {
            println(ROUND_NUMBER_MESSAGE)
        }
    }
}
