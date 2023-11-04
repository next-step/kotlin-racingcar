package study.racingcar.view

import study.racingcar.dto.RacingCar
import study.racingcar.dto.RacingCars

/**
 * RacingCar 리스트를 입력 받아서 각 RacingCar 의 상태에 부합하는 UI 를 출력한다.
 * */
object OutputView {
    fun showResult(racingCars: List<RacingCar>) {
        racingCars.forEach {
            println("${it.name} : ${"-".repeat(it.position)}")
        }
        println()
    }

    fun showWinners(racingCars: RacingCars): List<RacingCar> {
        val winner = racingCars.currentWinners

        println("최종 우승자는 ${winner.joinToString(",") { it.name.toString() }} 입니다.")
        return winner
    }
}
