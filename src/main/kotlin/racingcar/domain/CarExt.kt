package racingcar.domain

fun Car.moveOrStop(shouldMove: Boolean) {
    if (shouldMove) {
        move()
    } else {
        stop()
    }
}
