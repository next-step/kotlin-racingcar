package racingcar.ui

import racingcar.application.Winners

object WinnerMessageGenerator {
    private const val POSTFIX = "가 최종 우승했습니다."

    fun generate(winners: Winners): String {
        return winners.carNames.joinToString(separator = ",") + POSTFIX
    }
}
