package game.racingcar.domain

class Car {
    var blackBox = arrayListOf<Int>()
    var position: Int = 0

    fun move(): Int {
        position += 1
        blackBox.add(position)
        return position
    }

    fun history(time: Int): Int {
        return blackBox[time]
    }
}
