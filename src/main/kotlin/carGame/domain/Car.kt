package carGame.domain

class Car(val name: CarName, val position: Int) {
    fun move(): Car {
        return Car(name, position + 1)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Car

        return name == other.name
    }

    override fun hashCode(): Int {
        return name.hashCode()
    }

    companion object {
        fun atZeroPosition(name: CarName): Car {
            return Car(name = name, position = 0)
        }
    }
}
