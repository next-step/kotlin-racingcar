package carracing.util

import carracing.RacingMovementRole

class RacingMovementRoleForTest() : RacingMovementRole<Int> {
    override fun getMoveDistance(argument: Int): Int {
        return argument
    }

    override fun validate(argument: Int) {
        return
    }
}
