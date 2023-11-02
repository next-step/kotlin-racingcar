package step3.racing_car.ui

import step3.racing_car.interfaces.Movable
import kotlin.text.StringBuilder

private const val PLAY_RESULT_MSG = "실행 결과\n"
private const val MOVE_VIEW = "-"
private const val NEXT_STEP_VIEW = "\n"
private const val NEXT_ROUND_VIEW = "\n"

/**
 * 자동차 경주의 결과를 그리는 클래스
 * */
object ResultView {

    /**
     * 자동차 경주의 결과 메세지를 그림
     * */
    fun drawRacingResultMsg() {
        println(PLAY_RESULT_MSG)
    }

    /**
     * 자동차 경주의 현재 자동차 위치를 그림
     * */
    fun drawCarPosition(movableList: List<Movable>) {
        buildString {
            repeat(movableList.size) {
                append(drawPositionOfCar(movableList[it]))
                append(NEXT_STEP_VIEW)
            }
            append(NEXT_ROUND_VIEW)
            print(this)
        }
    }

    private fun drawPositionOfCar(movable: Movable): String {
        return buildString {
            repeat(movable.getCurrentPosition()) {
                append(MOVE_VIEW)
            }
        }
    }
}