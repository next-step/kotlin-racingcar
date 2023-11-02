package racing_car.parser

import racing_car.CAR_NAME_DELIMITER
import racing_car.interfaces.Movable
import racing_car.model.Car

private const val MOVABLE_NAME_DELIMITER = ','

/**
 * 자동차 경주 관련 Parser 오브젝트
 * */
object RacingParser {

    /**
     * 텍스트 -> 라운드 카운트 변환
     * */
    fun convertTextToRoundCnt(roundCntText: String?): Int {
        require(roundCntText?.isNotEmpty() == true && Int.MAX_VALUE.toString().length >= roundCntText.length && roundCntText.toIntOrNull() != null && roundCntText.toInt() > 0) {
            "Invalid Expression: $roundCntText"
        }
        return roundCntText?.toIntOrNull() ?: 0
    }

    /**
     * 텍스트 -> 자동차 리스트 변환
     * */
    fun convertTextToCarList(carNameListText: String?): List<Movable> {
        require(!carNameListText.isNullOrBlank() && carNameListText.last() != MOVABLE_NAME_DELIMITER && carNameListText.length < 6) {
            "Invalid Expression: $carNameListText"
        }

        val carNameList = carNameListText.split(CAR_NAME_DELIMITER)

        require(carNameList.all { it.isNotBlank() })

        return carNameList.map { Car(it) }
    }
}