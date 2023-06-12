package racing

object ResultView {
    private const val NEXT_LINE = "\n"
    private const val PROGRESS_STRING = "-"
    private const val SEPERATOR = ", "

    fun showResult(cars: MutableList<Car>, actionCount: Int) {
        println("실행 결과")
        repeat(actionCount) {
            gameStart(cars)
            print(NEXT_LINE)
        }
        print("${showWinner(cars)}가 최종 우승했습니다.")
    }

    private fun showWinner(cars: List<Car>): String {
        val firstGradePosition = cars.maxOf(Car::progress)
        return cars.filter {
            it.progress == firstGradePosition
        }.joinToString(SEPERATOR, transform = Car::name)
    }

    private fun gameStart(cars: List<Car>) {
        cars.forEach {
            car ->
            car.moveCar()
            showSkidMarks(car)
        }
    }

    private fun showSkidMarks(car: Car) {
        val progressString = StringBuffer()
        repeat(car.progress) {
            progressString.append(PROGRESS_STRING)
        }
        println("${car.name} : $progressString")
    }
}
