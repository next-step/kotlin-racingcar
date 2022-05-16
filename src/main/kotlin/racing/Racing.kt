package racing

import kotlin.random.Random

object Racing {
    private const val MIN_PIVOT_VALUE = 0
    private const val MAX_PIVOT_VALUE = 10

    fun start(carNames: List<String>, tryRound: Int): List<RacingCar> {
        validate(carNames)
        val racingCars: List<RacingCar> = carNames.map { RacingCar(tryRound, it) }

        repeat(tryRound) {
            for (car in racingCars) {
                car.race(createMovePoint())
            }
        }

        return racingCars
    }

    private fun validate(carNames: List<String>) {
        for(carName in carNames) {
            validateName(carName)
        }
    }

    private fun validateName(name: String) {
        if (name.length > 5 || name.isBlank()) {
            throw IllegalArgumentException("자동차 이름이 비어있거나 5자를 초과하였습니다.")
        }
    }

    private fun createMovePoint(): Int {
        return Random.nextInt(MIN_PIVOT_VALUE, MAX_PIVOT_VALUE)
    }
}
