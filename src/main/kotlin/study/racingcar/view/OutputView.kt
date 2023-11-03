package study.racingcar.view

import study.racingcar.domain.RacingCar
import study.racingcar.domain.RacingCars

/**
 * RacingCar 리스트를 입력 받아서 각 RacingCar 의 상태에 부합하는 UI 를 출력한다.
 * */
object OutputView {
    fun showResult(racingCars: List<RacingCar>) {
        racingCars.forEach {
            println("${it.name} : ${"-".repeat(it.currentPosition)}")
        }
        println()
    }

    fun showWinners(racingCars: RacingCars) {
        val winner = racingCars.currentWinners
        println("최종 우승자는 $winner 입니다.")
    }
}
