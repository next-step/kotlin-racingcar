package racingCar.view

import racingCar.domain.Car
import racingCar.domain.RaceLog


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
     * 경기 결과를 화면에 출력한다.
     */
    fun displayRaceResult(raceResult: RaceLog) {
        raceResult.carsLog.forEach{ displayRaceProgress(it) }

        val winners = raceResult.winners.joinToString(WINNER_DELIMITER) { it.name }
        println("${winners}가 최종 우승했습니다.")
    }

    /**
     * 경기 진행에 따른 자동차의 상태를 화면에 출력한다.
     */
    private fun displayRaceProgress(carList: List<Car>) {
        carList.forEach { displayCar(it) }
        println()
    }

    /**
     * 우승자를 화면에 출력한다.
     */
    private fun displayCar(car: Car) {
        println(car.name + NAME_DELIMITER + CAR_POSITION_MARK.repeat(car.position))
    }
}