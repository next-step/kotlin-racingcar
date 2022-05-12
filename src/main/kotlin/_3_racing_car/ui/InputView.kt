package _3_racing_car.ui

import _3_racing_car.domain.racer.Car
import _3_racing_car.domain.power.RandomPower
import _3_racing_car.service.InputDto
import _3_racing_car.service.Track

class InputView {
    private var count: Int = 0
    private var times: Int = 0

    fun print() {
        println("자동차 대수는 몇 대인가요?")
        count = readln().toInt()
        validatePositive(count)
        println("시도할 횟수는 몇 회인가요?")
        times = readln().toInt()
        validatePositive(times)
    }

    fun toInputDto() = InputDto(List(count) { Track(Car(), RandomPower()) }, times)

    private fun validatePositive(value: Int) = require(value > 0) { "요청값은 양수여야 합니다. value=$value" }
}
