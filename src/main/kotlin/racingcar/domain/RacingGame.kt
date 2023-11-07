package racingcar.domain

import racingcar.domain.interfaces.Raceable
import racingcar.domain.interfaces.Rankable

/**
 * 자동차 경주 게임
 * */
const val MIN_MOVE_RANDOM_VALUE = 0
const val MAX_MOVE_RANDOM_VALUE = 9
const val CAR_NAME_DELIMITER = ','

object RacingGame {

    private val randomMoveRange = (MIN_MOVE_RANDOM_VALUE..MAX_MOVE_RANDOM_VALUE)

    /**
     * 자동차 경주 시작
     * @param racingGameInfo first: 경주 자동차 리스트, second: 라운드 수
     * @param roundFinishListener 라운드 종료 리스너
     * */
    fun run(racingGameInfo: Pair<List<Raceable>, Int>, roundFinishListener: (List<Rankable>, Boolean) -> Unit) {

        var (raceableList: List<Raceable>, roundCnt: Int) = racingGameInfo

        repeat(roundCnt) { round ->
            raceableList = playRound(raceableList)
            roundFinishListener(raceableList, round == roundCnt - 1)
        }
    }

    /**
     * 라운드 시작
     * @param moveableList 자동차 리스트
     * @return 자동차 경주 한 라운드 결과를 가지고 있는 자동차 리스트
     * */
    private fun playRound(moveableList: List<Raceable>): List<Raceable> {
        val racingMutableList = mutableListOf<Raceable>()
        moveableList.forEach {
            it.move(randomMoveRange.random())
            racingMutableList.add(it)
        }
        return racingMutableList.toList()
    }
}
