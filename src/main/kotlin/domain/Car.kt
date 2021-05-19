package domain

import exception.InvalidCarNameException

class Car(name: String, distance: Int?) {
    val name: String
    val distance: Int

    constructor(name: String) : this(name, 0)


    init {
        validCarName(name)
        this.name = name
        when (distance) {
            null -> this.distance = 0
            else -> this.distance = distance
        }
    }

    private fun validCarName(name: String) {
        if (name.isEmpty()) {
            throw InvalidCarNameException("not allowed empty")
        }
        if (name.contains(" ")) {
            throw InvalidCarNameException("not allowed blank")
        }
    }

    fun move(): Car {
        return Car(name, distance + 1)
    }


}