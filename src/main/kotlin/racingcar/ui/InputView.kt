package racingcar.ui

import racingcar.domain.Name
import racingcar.domain.RacingCar
import racingcar.domain.RacingGame
import racingcar.domain.carracer.RandomCarRacer

class InputView {

    fun inputNumberOfAttempts(): Int {
        println("시도할 횟수는 몇 회인가요?")
        return readLine()!!.toInt()
    }

    fun inputRacingGame(): RacingGame {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        val names = readLine()!!.toString().split(',')

        return RacingGame(names.map { RacingCar(Name(it), RandomCarRacer()) })
    }
}
