package _3_racing_car.ui
import _3_racing_car.ui.dto.GameInputDto

class InputView {

    fun read(): GameInputDto {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)")
        val gamers = readln().split(',')
        println("시도할 횟수는 몇 회인가요?")
        val times = readln().toInt()
        validatePositive(times)
        return GameInputDto(gamers, times)
    }

    private fun validatePositive(value: Int) = require(value > 0) { "요청값은 양수여야 합니다. value=$value" }
}
