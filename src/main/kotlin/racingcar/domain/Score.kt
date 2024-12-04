package racingcar.domain

import racingcar.domain.Car.Companion.BLANK_NAME

data class Score(
    val point: Int,
    val carName: String,
) {
    fun isSameScore(maxScore: Int): Boolean {
        return point == maxScore
    }
}

fun Score(car: Car): Score {
    return Score(car.point, car.carName.name)
}

fun Score(point: Int): Score {
    return Score(point, BLANK_NAME)
}
