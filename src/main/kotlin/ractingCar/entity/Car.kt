package ractingCar.entity

class Car(var moves: Int = 0) {

    fun move() {
        val range = (0..9)
        goForward(range.random())
    }

    fun goForward(rand: Int) {
        if (rand >= 4) this.moves += 1
    }

    fun printMoves() {
        println("-".repeat(this.moves))
    }
}