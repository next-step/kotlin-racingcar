package racingcar.history

import racingcar.domain.Car

data class RacingActionHistory(val position: Int) {
    companion object {
        fun of(car: Car): RacingActionHistory {
            return RacingActionHistory(position = car.position)
        }
    }
}
