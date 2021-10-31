package racingcar.car

import racingcar.engine.RandomEngine

class Cars(carsName: String) {
    val carList: List<Car> = CarFactory.initCarList(carsName, RandomEngine())

    fun startRound(): List<Car> {
        return carList.map { car ->
            car.start()
        }
    }

    private fun getHighScore(): Int? {
        return carList.map {
            it.getLocation().length
        }.maxOrNull()
    }

    fun getWinner(): List<String> {
        val highScore = getHighScore()
        return carList.filter {
            it.getLocation().length == highScore
        }.map {
            it.name
        }
    }
}
