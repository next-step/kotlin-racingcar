package step4.presentation

import step4.domain.CarName
import step4.domain.InputSupplier
import step4.domain.InputView
import step4.domain.RacingCar
import step4.domain.RacingCars
import step4.domain.RacingCourse

class RacingGameInputView(private val inputSupplier: InputSupplier) : InputView<RacingCourse> {
    override fun enter(): RacingCourse {
        val cars = enterCars()
        val tryCount = enterTryCount()
        return RacingCourse(tryCount, cars)
    }

    fun enterCars(): RacingCars {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        return RacingCars(parseLine(inputSupplier.read()))
    }

    private fun parseLine(line: String): List<RacingCar> {
        return line.split(",").map { RacingCar(CarName(it)) }
    }

    fun enterTryCount(): Int {
        println("시도할 횟수는 몇 회인가요?")
        return inputSupplier.read().toInt()
    }
}
