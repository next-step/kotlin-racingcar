package racingcar.car

import racingcar.engine.RandomEngine

class Cars(carsName: String) {
    val carList: List<Car> = CarFactory.initCarList(carsName, RandomEngine())

    fun startRound(): List<Car> {
        return carList.map { car ->
            car.start()
        }
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
