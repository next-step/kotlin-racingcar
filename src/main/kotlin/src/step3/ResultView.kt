package src.step3

object ResultView {
    fun showGameResult(carNumber: String, tryCount: Int) {
        val cars = mutableListOf<Car>()

        // 자동차 대수 만큼 생성
        CarOperator.makeCar(cars, carNumber)

        // 자동차 주행 거리 계산
        CarOperator.calculateCarMoveDistance(cars, tryCount, getCarMoveRandomValue())

        // 자동차 주행 거리 출력
        printRacingCarGameResult(cars)
    }

    private fun printRacingCarGameResult(cars: MutableList<Car>) {
        for (i in 0 until cars.first().moveCounts.size) {
            for (car in cars) {
                println("-".repeat(car.moveCounts[i] + 1))
            }
            println()
        }
    }
}
