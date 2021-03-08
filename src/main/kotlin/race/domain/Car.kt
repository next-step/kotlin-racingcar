package race.domain

class Car {
    var position = 0

    fun move(condition: Int): Car {
        if (condition > 9 || condition < 0) {
            throw IllegalArgumentException("condition is between 0 and 9.")
        }

        if (condition >= 4) {
            position++
        }

        return this
    }
}
