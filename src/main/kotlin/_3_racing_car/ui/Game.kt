package _3_racing_car.ui

import _3_racing_car.service.Racing

class Game {
    fun play(racing: Racing, times: Int): ResultView {
        val racingOutput = racing.start(times)
        return ResultView(racingOutput)
    }
}
