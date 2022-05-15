package game.racingcar.domain

import kotlin.random.Random

class Car {
    var blackBox = arrayListOf<Int>()
    var position: Int = 0

    fun move(): Int {

        if (Random.nextInt(0, 10) >= 4) {
            position += 1
        }

        blackBox.add(position)
        return position
    }

    fun history(time: Int): Int {
        return blackBox[time]
    }
}
