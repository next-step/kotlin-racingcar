package racingcar.domain.car

import racingcar.domain.car.engine.RandomEngine
import racingcar.domain.dto.Record

class Cars(carsName: String) {
    val carList: List<Car> = CarFactory.initCarList(carsName, RandomEngine())

    fun startRound(): Record {
        carList.forEach { car ->
            car.start()
        }
        return Record(carList)
    }

    private fun getHighScore(): Int {
        return carList.maxOf {
            it.distance
        }
    }

    fun getWinner(): List<String> {
        val highScore = getHighScore()
        return carList.filter {
            it.distance == highScore
        }.map {
            it.name
        }
    }
}
