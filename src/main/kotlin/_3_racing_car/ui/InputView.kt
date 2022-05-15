package _3_racing_car.ui

import _3_racing_car.domain.power.RandomPower
import _3_racing_car.domain.racer.Car
import _3_racing_car.service.Track
import _3_racing_car.service.dto.RacingInputDto

class InputView {

    fun read(): RacingInputDto {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)")
        val names = readln().split(',')
        validateNameLength(names)
        println("시도할 횟수는 몇 회인가요?")
        val times = readln().toInt()
        validatePositive(times)

        val tracks = names.map { Track(Car(it), RandomPower()) }
        return RacingInputDto(tracks, times)
    }

    private fun validateNameLength(names: List<String>) = names.forEach {
        require(it.length <= 5) { "자동차 이름은 5자를 초과할 수 없습니다. name=$it" }
    }

    private fun validatePositive(value: Int) = require(value > 0) { "요청값은 양수여야 합니다. value=$value" }
}
