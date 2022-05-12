package racing

object CarRacingResultView {
    fun printCarRacingResult(cars: List<Car>, moveCount: Int) {
        // turnOfPosition의 0번 index는 기본으로 1이 셋팅되어있기때문에
        // 범위를 0 <= moveIndex <= moveCount 로 설정
        for (moveIndex in 0..moveCount) {
            printMovingDistanceByTurn(cars = cars, moveIndex = moveIndex)
        }
    }

    private fun printMovingDistanceByTurn(cars: List<Car>, moveIndex: Int) {
        cars.forEach { car ->
            printCurrentCarMovingDistance(carName = car.name, carPosition = car.turnOfPosition[moveIndex])
        }
        println()
    }

    private fun printCurrentCarMovingDistance(carName: String, carPosition: Int) {
        println("$carName : ".plus("-".repeat(carPosition)))
    }

    fun printWinners(carNames: List<String>) {
        println("${carNames}가 최종 우승했습니다.")
    }
}
