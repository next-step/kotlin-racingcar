package step3.racing_car.ui

/**
 * 자동차 경주의 결과를 그리는 클래스
 *
 * @author KimJungSik
 * @since 2023/10/28
 * */
class ResultView {

    private val PLAY_RESULT_MSG = "실행 결과\n"
    private val MOVE_VIEW = "-"

    fun drawRacingResultMsg() {
        println(PLAY_RESULT_MSG)
    }

    /**
     * 자동차 경주의 결과 값을 그림
     * */
    fun drawRacingResult(racingResultList: List<Int>) {
        racingResultList.forEach { movePosition ->
            repeat(movePosition) {
                print(MOVE_VIEW)
            }
            println()
        }
        println()
    }
}