package racing.domain.car

import racing.domain.formula.MoveFormula

class Car internal constructor(
    val name: String,
    position: Int,
) {

    var position: Int = position
        private set

    @Synchronized
    fun move(moveFormula: MoveFormula): Int = if (moveFormula.move()) {
        ++position
    } else {
        position
    }

    override fun equals(other: Any?): Boolean = when {
        this === other -> true
        other !is Car -> false
        name != other.name -> false
        position != other.position -> false
        else -> true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + position
        return result
    }
}
