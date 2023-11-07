package racingcar.domain.parser

import racingcar.domain.CAR_NAME_DELIMITER
import racingcar.domain.interfaces.Moveable
import racingcar.domain.interfaces.Raceable
import racingcar.domain.interfaces.Rankable
import racingcar.domain.model.Car
import racingcar.domain.util.Extends.toIntOrDefault

private const val MOVABLE_NAME_DELIMITER = ','
private const val CAR_NAME_MAX_LENGTH = 5
private const val DEFAULT_ROUND_COUNT = 1

/**
 * 자동차 경주 관련 Parser 오브젝트
 * */
object RacingParser {

    /**
     * 텍스트 -> 라운드 카운트 변환
     * */
    fun convertTextToRoundCnt(roundCntText: String?): Int {
        require(!roundCntText.isNullOrEmpty() && Int.MAX_VALUE.toString().length >= roundCntText.length && roundCntText.toIntOrNull() != null && roundCntText.toInt() > 0) {
            "Invalid Expression: $roundCntText"
        }
        return roundCntText.toIntOrDefault(DEFAULT_ROUND_COUNT)
    }

    /**
     * 텍스트 -> 자동차 경주 리스트 변환
     * */
    fun convertTextToCarList(carNameListText: String?): List<Raceable> {
        require(!carNameListText.isNullOrBlank() && carNameListText.last() != MOVABLE_NAME_DELIMITER) {
            "Invalid Expression: $carNameListText"
        }

        val carNameList = carNameListText.split(CAR_NAME_DELIMITER)

        require(carNameList.all { carName -> carName.isNotBlank() && carName.length <= CAR_NAME_MAX_LENGTH }) {
            "Invalid Expression: $carNameListText"
        }

        return carNameList.map { Car(it) }
    }
}
