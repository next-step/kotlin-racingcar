package racingcar.business

import racingcar.domain.GameResult
import racingcar.domain.collection.Cars
import racingcar.domain.collection.RoundRecord
import racingcar.utils.NumberGenerator

class RacingGame(
    private val numOfMove: Int,
    carNames: List<String>,
    numberGenerator: NumberGenerator
) {
    init {
        val numOfPlayer: Int = carNames.size

        require(numOfPlayer > 0) {
            "플레이어는 조건은 최소 1명 이상입니다."
        }

        require(numOfMove > 0) {
            "이동 횟수 조건은 최소 1번 이상입니다."
        }
    }

    private val cars: Cars = Cars.generateCars(carNames, numberGenerator)

    fun play(): GameResult {
        val result = mutableListOf<RoundRecord>()
        repeat(numOfMove) {
            cars.run()
            result.add(cars.getCarRecords())
        }

        return GameResult(result)
    }
}
