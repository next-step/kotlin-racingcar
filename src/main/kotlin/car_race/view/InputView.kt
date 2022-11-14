package car_race.view

import car_race.logic.GameRound
import car_race.logic.car.Cars

object InputView {

    fun inputGameRound(): GameRound {
        println("시도할 횟수는 몇 회인가요?")
        val input = readlnOrNull() ?: throw IllegalArgumentException("null 입력은 허용하지 않습니다.")
        return GameRound.from(input)
    }

    fun inputCarCount(): Cars {
        println("자동차 대수는 몇 대인가요?")
        val input = readlnOrNull() ?: throw IllegalArgumentException("null 입력은 허용하지 않습니다.")
        return Cars.from(input)
    }
}
