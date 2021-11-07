package racingcar.domain.car

import racingcar.domain.car.engine.RandomEngine

class Cars(carsName: String) {
    val carList: List<Car> = CarFactory.initCarList(carsName, RandomEngine())

    fun startRound(): List<Car> {
        carList.forEach { car ->
            car.start()
        }
        return carList
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
