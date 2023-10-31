package racingcar.view

import racingcar.domain.Nickname

object InputView {

    private const val NICKNAME_QUESTION = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)"
    private const val TOTAL_ROUND_QUESTION = "시도할 회수는 몇 회 인가요?"

    private const val NICKNAME_SEPARATOR = ","

    fun readNicknames(): List<Nickname> {
        println(NICKNAME_QUESTION)
        return readln().split(NICKNAME_SEPARATOR)
            .map { Nickname(it) }
    }

    fun readTotalRound(): Int {
        println(TOTAL_ROUND_QUESTION)
        return readln().toInt()
    }
}
