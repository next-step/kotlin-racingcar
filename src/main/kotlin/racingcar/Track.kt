package racingcar

import racingcar.io.ResultView

class Track(private val random: ForwardStrategy) {

    tailrec fun play(playCount: Int, cars: List<Car>): List<Car> {
        if (playCount == 0) return cars

        val movedCars = this.move(cars)
        this.printResult(movedCars)

        return this.play(playCount.dec(), movedCars)
    }

    private fun printResult(cars: List<Car>) {
        cars.forEach { car ->
            ResultView.printResult(name = car.name, distance = car.position)
        }

        ResultView.printNewLine()
    }

    private fun move(cars: List<Car>): List<Car> =
        cars.map { car ->
            car.move(this.random.generateInt())
        }
}
