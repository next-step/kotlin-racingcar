package step3.view

import step3.domain.Car


object DisplayView {
    private const val CAR_POSITION_MARK = "-"
    private const val NAME_DELIMITER = " : "
    private const val WINNER_DELIMITER = ", "

    /**
     * 경주가 시작되는 것을 알린다.
     */
    fun displayHeader() {
        println("\n실행결과")
    }

    /**
     * 한 번 진행이 될 때마다 자동차의 상태를 화면에 출력한다.
     */
    fun displayRaceProgress(carList: List<Car>) {
        carList.forEach { displayCar(it) }
        println()
    }

    /**
     * 우승자를 화면에 출력한다.
     */
    fun displayRaceResult(carList: List<Car>) {
        val winners = carList.joinToString(WINNER_DELIMITER) { it.name }
        println("${winners}가 최종 우승했습니다.")
    }

    private fun displayCar(car: Car) {
        println(car.name + NAME_DELIMITER + CAR_POSITION_MARK.repeat(car.position))
    }
}