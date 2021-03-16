package racingcar.history

import racingcar.domain.Car

data class RacingActionHistory(val position: Int, val userName: String) {
    companion object {
        fun of(car: Car): RacingActionHistory {
            return RacingActionHistory(position = car.position, userName = car.userName)
        }
    }
}
