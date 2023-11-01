package racing

import kotlin.random.Random

class Car {
    private var route = ""

    fun forward() {
        val random = Random.nextInt(0, 10)
        if (random >= 4) {
            route += "-"
        }
    }

    fun getRoute(): String {
        return route
    }
}
