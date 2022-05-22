package racing.ui

import racing.domain.Names
import racing.domain.vo.CarInput
import racing.domain.vo.Name
import racing.domain.vo.Times

class InputView {
    fun getInput(): CarInput {
        val carInput = CarInput(getNameOfCars(), getNumberOfTimes())
        println()

        return carInput
    }

    private fun getNameOfCars(): Names {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        val carNames = readlnOrNull() ?: throw IllegalArgumentException()
        return Names(carNames.split(NAME_DELIMITER).map { Name(it) })
    }

    private fun getNumberOfTimes(): Times {
        println("시도할 횟수는 몇 회인가요?")
        val times = readln().toIntOrNull() ?: throw IllegalArgumentException()
        return Times(times)
    }

    companion object {
        private const val NAME_DELIMITER = ","
    }
}
