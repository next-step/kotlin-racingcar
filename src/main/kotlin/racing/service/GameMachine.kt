package racing.service

import racing.model.Car
import racing.model.Racing

object GameMachine {

    fun getWinningCarName(racing: Racing): List<Car> {
        val maxPosition = racing.cars.maxOf { it.position }
        return racing.cars.filter { it.position == maxPosition }.toMutableList()
    }

    fun play(carNames: String, tryGameCount: Int): Racing {
        val racing = Racing(carNames.split(","), tryGameCount)
        racing.play()
        return racing
    }
}
