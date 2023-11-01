package game.racing.util

import game.racing.domain.Car

fun getRandomValue(): Int {
    return (Car.MIN_RANDOM_VALUE..Car.MAX_RANDOM_VALUE).random()
}
