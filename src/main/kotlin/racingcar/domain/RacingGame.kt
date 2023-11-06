package racingcar.domain

import racingcar.domain.interfaces.Raceable

/**
 * 자동차 경주 게임
 * */
const val MIN_RANDOM_VALUE = 0
const val MAX_RANDOM_VALUE = 9
const val CAR_NAME_DELIMITER = ','

object RacingGame {

    /**
     * 자동차 경주 시작
     * @param racingGameInfo first: 경주 자동차 리스트, second: 라운드 수
     * @param roundFinishListener 라운드 종료 리스너
     * */
    fun run(racingGameInfo: Pair<List<Raceable>, Int>, roundFinishListener: (List<Raceable>, Boolean) -> Unit) {

        var (carList, roundCnt) = racingGameInfo

        repeat(roundCnt) { round ->
            carList = playRound(carList)
            roundFinishListener(carList, round == roundCnt - 1)
        }
    }

    /**
     * 게임 시작
     * @param raceableList 자동차 리스트
     * @return 자동차 경주 한 라운드 결과를 가지고 있는 자동차 리스트
     * */
    private fun playRound(raceableList: List<Raceable>): List<Raceable> =
        raceableList.map { it.move((MIN_RANDOM_VALUE..MAX_RANDOM_VALUE).random()); it }
}