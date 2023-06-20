package step3.view

import step3.Car


object DisplayView {
    private const val CAR_POSITION_MARK = "-"

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

    private fun displayCar(car: Car) {
        println(CAR_POSITION_MARK.repeat(car.position))
    }
}