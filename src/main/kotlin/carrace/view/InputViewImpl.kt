package carrace.view

import carrace.logic.GameRound
import carrace.logic.car.CarNames
import carrace.logic.car.Cars

object InputViewImpl : InputView {

    override fun inputGameRound(): GameRound {
        println("시도할 횟수는 몇 회인가요?")
        val input = readlnOrNull() ?: throw IllegalArgumentException("null 입력은 허용하지 않습니다.")
        return GameRound.from(input)
    }

    override fun inputCars(): Cars {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        val input = readlnOrNull() ?: throw IllegalArgumentException("null 입력은 허용하지 않습니다.")
        val carNames = CarNames(input)
        return Cars(carNames)
    }
}
