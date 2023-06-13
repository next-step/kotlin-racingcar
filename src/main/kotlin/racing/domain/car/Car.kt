package racing.domain.car

import racing.domain.formula.MoveFormula
import racing.domain.formula.MoveState
import racing.model.RaceGameErrorCode

class Car internal constructor(
    val name: String,
    position: Int,
) {

    init {
        require(value = name.length <= MAX_NAME_SIZE && name.isNotBlank()) {
            RaceGameErrorCode.INVALID_CAR_NAME_INPUT.message("$name $MAX_NAME_SIZE")
        }
    }

    var position: Int = position
        private set

    @Synchronized
    fun move(moveFormula: MoveFormula): Int = when (moveFormula.move()) {
        MoveState.GO -> ++position
        MoveState.STOP -> position
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

    companion object {
        private const val MAX_NAME_SIZE = 5
    }
}
