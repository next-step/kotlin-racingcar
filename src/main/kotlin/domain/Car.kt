package domain

import exception.InvalidCarNameException

class Car(name: String, distance: Int) {
    private val name: String
    private val distance: Int

    init {
        validCarName(name)
        this.name = name
        this.distance = distance
    }

    private fun validCarName(name: String) {
        if (name.isEmpty()) {
            throw InvalidCarNameException("not allowed empty")
        }
//        if (name.contains(" ")) {
//            throw InvalidCarNameException("not allowed blank")
//        }
    }
}