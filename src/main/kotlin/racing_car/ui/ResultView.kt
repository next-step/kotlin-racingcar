package racing_car.ui

import racing_car.interfaces.Movable

private const val PLAY_RESULT_MSG_VIEW = "실행 결과\n"

private const val MOVE_VIEW = '-'
private const val MOVABLE_SEPARATOR_VIEW = ""
private const val MOVABLE_NAME_DELIMITER_VIEW = " : "

private const val NEXT_STEP_VIEW = "\n"
private const val NEXT_ROUND_VIEW = "\n"

private const val WINNERS_CELEBRATE_VIEW = "가 최종 우승했습니다."

/**
 * 자동차 경주의 결과를 그리는 클래스
 * */
object ResultView {

    /**
     * 자동차 경주의 결과 메세지를 그림
     * */
    fun drawRacingResultMsg() {
        println(PLAY_RESULT_MSG_VIEW)
    }

    /**
     * 자동차 경주의 현재 자동차의 상태를 그림
     * */
    fun drawCarStateList(movableList: List<Movable>) {
        print(getCarStateListView(movableList) + NEXT_ROUND_VIEW)
    }

    /**
     * 자동차 경주 우승 자동차의 이름을 그림
     * */
    fun drawRacingWinners(movableList: List<Movable>): String {
        return buildString {
            append(getWinnerNamesView(movableList))
            append(WINNERS_CELEBRATE_VIEW)
            print(this)
        }
    }

    private fun getCarStateView(movable: Movable): String {
        return "${movable.getName()}$MOVABLE_NAME_DELIMITER_VIEW${getCarPositionView(movable)}$NEXT_STEP_VIEW"
    }

    private fun getCarStateListView(movableList: List<Movable>): String {
        return movableList.joinToString(MOVABLE_SEPARATOR_VIEW) { getCarStateView(it) }
    }

    private fun getCarPositionView(movable: Movable): String {
        return String(CharArray(movable.getCurrentPosition()) { MOVE_VIEW })
    }
    private fun getWinnerPosition(movableList: List<Movable>): Int {
        return movableList.maxOf { it.getCurrentPosition() }
    }

    private fun getWinnerNamesView(movableList: List<Movable>): String {
        val winnerPosition = getWinnerPosition(movableList)
        val winnerList = movableList.filter {
            winnerPosition == it.getCurrentPosition()
        }
        return winnerList.joinToString { it.getName() }
    }
}