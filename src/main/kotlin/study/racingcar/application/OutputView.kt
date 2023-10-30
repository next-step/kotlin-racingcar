package study.racingcar.application

import study.racingcar.domain.RacingCar

/**
 * RacingCar 리스트를 입력 받아서 각 RacingCar 의 상태에 부합하는 UI 를 출력한다.
 * */
class OutputView {
    fun showResult(racingCars: List<RacingCar>) {
        racingCars.forEach {
            println("${it.id} : ${"-".repeat(it.currentPosition)}")
        }
        println()
    }
}
