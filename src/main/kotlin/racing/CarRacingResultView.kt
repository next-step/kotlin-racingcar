package racing

object CarRacingResultView {
    fun printCarRacingResult(cars: List<Car>, moveCount: Int) {
        // turnOfPosition의 0번 index는 기본으로 1이 셋팅되어있기때문에
        // 범위를 0 <= moveIndex <= moveCount 로 설정
        for (moveIndex in 0..moveCount) {
            cars.forEach { car ->
                printCurrentCarMovingDistance(car.turnOfPosition[moveIndex])
            }
            println()
        }
    }

    private fun printCurrentCarMovingDistance(carPosition: Int) {
        println("_ ".repeat(carPosition))
    }
}
