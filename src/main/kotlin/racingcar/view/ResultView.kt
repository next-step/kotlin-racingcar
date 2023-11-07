package racingcar.view

import racingcar.domain.interfaces.Rankable

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
    fun drawCarStateList(raceableList: List<Rankable>) {
        print(getCarStateListView(raceableList) + NEXT_ROUND_VIEW)
    }

    /**
     * 자동차 경주 우승 자동차의 이름을 그림
     * */
    fun drawRacingWinners(raceableList: List<Rankable>): String {
        return buildString {
            append(getWinnerNamesView(raceableList))
            append(WINNERS_CELEBRATE_VIEW)
            print(this)
        }
    }

    private fun getCarStateView(raceAble: Rankable): String {
        return "${raceAble.name}$MOVABLE_NAME_DELIMITER_VIEW${getCarPositionView(raceAble)}$NEXT_STEP_VIEW"
    }

    private fun getCarStateListView(raceableList: List<Rankable>): String {
        return raceableList.joinToString(MOVABLE_SEPARATOR_VIEW) { getCarStateView(it) }
    }

    private fun getCarPositionView(raceAble: Rankable): String {
        return String(CharArray(raceAble.position) { MOVE_VIEW })
    }
    private fun getWinnerPosition(raceableList: List<Rankable>): Int {
        return raceableList.maxOf { it.position }
    }

    private fun getWinnerNamesView(raceableList: List<Rankable>): String {
        val winnerPosition = getWinnerPosition(raceableList)
        val winnerList = raceableList.filter {
            winnerPosition == it.position
        }
        return winnerList.joinToString { it.name }
    }
}
