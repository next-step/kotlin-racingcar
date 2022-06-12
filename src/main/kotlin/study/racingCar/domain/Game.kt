package study.racingCar.domain

class Game {
    fun startGame(carNames: List<String>, movingTryNum: Int): List<List<Pair<String, Int>>> {
        val cars = carNames.map { carName -> Car(carName) }

        return (0 until movingTryNum).map {
            cars.map { car ->
                car.tryMove()
                Pair(car.carName, car.mileage)
            }
        }
    }
}
