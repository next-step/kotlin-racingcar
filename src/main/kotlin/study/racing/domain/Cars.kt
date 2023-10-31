package study.racing.domain

import study.racing.strategy.MoveStrategy
import study.racing.strategy.RandomMoveStrategy

class Cars private constructor(
    private val cars: List<Car> = listOf()
) : List<Car> by cars {

    init {
        require(cars.isNotEmpty()) {
            "차량은 최소 1대 이상 요청해 주세요."
        }
    }

    fun moveTheCars() {
        this.cars.forEach { car ->
            car.tryMoveTheCar()
        }
    }

    fun getCarsMoveDistance(): List<Int> = this.cars.map {
        it.getCarDistance()
    }.toList()

    fun getRacingWinnerNames(): List<String> {

        val maxDistance = findMaxDistance()

        return this.cars.filter {
            it.getCarDistance() == maxDistance
        }.map {
            it.getCarName()
        }
    }

    private fun findMaxDistance(): Int = this.cars.maxOf {
        it.getCarDistance()
    }

    fun copy(): Cars {
        return Cars(
            this.cars.map {
                it.copy()
            }
        )
    }

    companion object {
        fun from(
            carNames: String
        ): Cars {
            return Cars(createEachCarNameOfCars(splitCarNames(carNames)))
        }

        private fun splitCarNames(carNames: String): List<CarName> {

            require(carNames.isNotEmpty()) {
                "차량 이름을 정상적으로 등록해 주세요. 여러대 등록시 ',' 로 구분해서 작성해 주세요."
            }

            return carNames.trim()
                .split(",")
                .map {
                    CarName(it)
                }
        }

        fun of(
            carNames: String,
            strategy: MoveStrategy
        ): Cars {
            return Cars(
                createEachCarNameOfCars(splitCarNames(carNames), strategy),
            )
        }

        private fun createEachCarNameOfCars(carNames: List<CarName>): List<Car> = List(carNames.size) {
            Car(RandomMoveStrategy(), carNames[it])
        }

        private fun createEachCarNameOfCars(carNames: List<CarName>, strategy: MoveStrategy): List<Car> =
            List(carNames.size) {
                Car(strategy, carNames[it])
            }
    }
}
