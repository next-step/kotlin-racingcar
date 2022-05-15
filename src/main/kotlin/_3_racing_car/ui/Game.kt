package _3_racing_car.ui

import _3_racing_car.service.Racing
import _3_racing_car.service.dto.RacingInputDto

class Game {
    fun play(racingInput: RacingInputDto): ResultView {
        val racing = Racing()
        val result = racing.run(racingInput)
        return ResultView(result)
    }
}
