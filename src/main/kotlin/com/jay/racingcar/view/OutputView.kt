package com.jay.racingcar.view

import com.jay.racingcar.domain.RacingCar
import com.jay.racingcar.domain.RacingCars
import kotlin.streams.toList

object OutputView {
    private const val DISTANCE_MARK = "-"
    private const val CAR_NAME_MARK = " : "

    fun printCarInputMessage() {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
    }

    fun printTryMessage() {
        println("시도할 횟수는 몇 회인가요?")
    }

    fun printOutputMessage() {
        println("실행 결과")
    }

    private fun printWinnerMessage() {
        println("가 최종 우승했습니다.")
    }

    fun printResult(racingCars: RacingCars) {
        racingCars.racingCars
            .forEach {
                print(it.getNameValue() + CAR_NAME_MARK)
                println(DISTANCE_MARK.repeat(it.getPosition()))
            }
        println()
    }

    fun printWinners(winners: List<RacingCar>) {
        print(winners.stream().map { it.getNameValue() }.toList().joinToString(separator = ","))
        print(winners.joinToString(separator = ",") { it.getNameValue() })
        printWinnerMessage()
    }
}
