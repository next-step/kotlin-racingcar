package step3

import kotlin.random.Random

class Rule {
    fun makeFollow(car: Car) {
        if (Random.nextInt(10) >= 4) {
            car.move()
        }
    }
}
