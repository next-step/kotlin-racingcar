package study.racingcar.view

class RacingView {

    companion object {
        internal val RACING_WINNER_MESSAGE = { winner: String -> "${winner}가 최종 우승했습니다." }
        internal const val CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
        internal const val ROUND_NUMBER_MESSAGE = "시도할 횟수는 몇 회인가요?"
        internal const val RACE_RESULT_MESSAGE = "실행 결과"
    }
}
