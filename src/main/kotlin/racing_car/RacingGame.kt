package racing_car

import racing_car.interfaces.Movable
import racing_car.model.Car

/**
 * 자동차 경주 게임
 * */
const val MIN_RANDOM_VALUE = 0
const val MAX_RANDOM_VALUE = 9
const val CAR_NAME_DELIMITER = ','

object RacingGame {

    /**
     * 게임 시작
     * @param movableList 자동차 리스트
     * @return 자동차 경주 한 라운드 결과를 가지고 있는 자동차 리스트
     * */
    fun playRound(movableList: List<Movable>): List<Movable> = movableList.map { it.move((MIN_RANDOM_VALUE..MAX_RANDOM_VALUE).random()); it }
}