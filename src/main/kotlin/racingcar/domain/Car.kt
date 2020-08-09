package racingcar.domain

const val CAR_NAME_MAX_LENGTH = 5

data class Car(val name: String, val distance: Int = 0) {
    init {
        if (name.length > CAR_NAME_MAX_LENGTH) throw NameLengthOverflowException()
    }

    fun move(): Car {
        return copy(name = name, distance = distance + 1)
    }

    fun moveIf(predicate: () -> Boolean): Car {
        return if (predicate()) {
            move()
        } else {
            this
        }
    }

    class NameLengthOverflowException : Exception("A car's name must be shorter.")
}
