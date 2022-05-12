package _3_racing_car.ui

import _3_racing_car.service.Racing

class Game {
    fun play(inputView: InputView): ResultView {
        val inputDto = inputView.toInputDto()
        val racing = Racing()
        val result = racing.run(inputDto)
        return ResultView(result)
    }
}
