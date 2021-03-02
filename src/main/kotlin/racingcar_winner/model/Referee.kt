package racingcar_winner.model

class Referee {

    fun getWinners(cars: Cars): List<String> {
        val highScore = getHighScore(cars)

        return cars.getProgressOfCars().filter { car ->
            car.value == highScore
        }.keys.toList()
    }

    private fun getHighScore(cars: Cars): Int {
        return cars.getProgressOfCars().values.max()!!
    }
}
