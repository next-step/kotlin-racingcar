package step3.racing_car.ui

import step3.racing_car.Car
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
    fun drawCarPosition(carList: List<Car>) {
        val sb = StringBuilder()
        carList.forEach { car ->
            sb.append(drawPositionOfCar(car))
            sb.append(NEXT_STEP_VIEW)
        }
        sb.append(NEXT_ROUND_VIEW)
        print(sb)
    }

    private fun drawPositionOfCar(car: Car): StringBuilder {
        val sb = StringBuilder()
        repeat(car.position) {
            sb.append(MOVE_VIEW)
        }
        return sb
    }
}