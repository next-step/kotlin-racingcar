package racingcar

class RacingCar(private val cars: Cars) {
    companion object {
        fun ready(numberOfCars: Int): RacingCar {
            var cars = Cars.makeCars(numberOfCars)
            return RacingCar(cars)
        }
    }

    fun runOnce() {
        cars.getCars()
            .forEach { car: Car ->
                val randomNumber = RandomNumber.getBetweenZeroAnd(10)
                val canMove = MoveStrategy.canMove(randomNumber)
                car.move(canMove)
            }
    }

    fun writeScores() {
        cars.getCars()
            .forEach { car: Car ->
                println(car.score)
            }
    }
}
