package racingcar.domain.to

import racingcar.domain.Car
import racingcar.domain.vo.CarPosition

class GameHistoryResponse(private val raceHistory: Map<Car, List<CarPosition>>) {
    val to: LinkedHashMap<String, List<Int>> = LinkedHashMap()

    init {
        raceHistory.forEach { (car, carPositionList) ->
            to[car.getNameValue()] = carPositionList.map { it.value }
        }
    }
}
