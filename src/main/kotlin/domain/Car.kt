package domain

import exception.InvalidCarNameException

class Car(val name: String, distance: Int) {
    var distance: Int = distance
        private set

    constructor(name: String) : this(name, 0)
    constructor(name: String, distance: Int?) : this(name, 0)

    init {
        validCarName(name)
    }

    private fun validCarName(name: String) {
        if (name.isEmpty()) {
            throw InvalidCarNameException("not allowed empty")
        }
        if (name.contains(" ")) {
            throw InvalidCarNameException("not allowed blank")
        }
    }

    fun move() {
        this.distance++
    }
}