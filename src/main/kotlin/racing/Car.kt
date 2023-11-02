package racing

import kotlin.random.Random

data class Car(
    var position: Int
) {
    fun printPosition() {
        repeat(position) {
            print("-")
        }
        println("")
    }
    
    fun move() {
        if (Random.nextInt(10) > 4) {
            position += 1
        }
    }
}
