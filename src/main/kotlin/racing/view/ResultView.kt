package racing.view

import racing.domain.Car
import racing.CarRandomGenerator

object ResultView {
    private const val NEXT_LINE = "\n"
    private const val PROGRESS_STRING = "-"
    private const val SEPERATOR = ", "
    private const val MAX_RANGE = 10

    fun showResult(cars: List<Car>, actionCount: Int) {
        println("실행 결과")
        repeat(actionCount) {
            gameStart(cars)
            print(NEXT_LINE)
        }
        print("${showWinner(cars)}가 최종 우승했습니다.")
    }

    private fun showWinner(cars: List<Car>): String {
        val firstGradePosition = cars.maxOf(Car::position)
        return cars.filter {
            it.position == firstGradePosition
        }.joinToString(SEPERATOR, transform = Car::name)
    }

    private fun gameStart(cars: List<Car>) {
        cars.forEach {
            car ->
            car.moveCar(CarRandomGenerator.createRandom(MAX_RANGE))
            showSkidMarks(car)
        }
    }

    private fun showSkidMarks(car: Car) {
        val progressString = StringBuffer()
        repeat(car.position) {
            progressString.append(PROGRESS_STRING)
        }
        println("${car.name} : $progressString")
    }
}
