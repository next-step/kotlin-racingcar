package carracing.model.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CarTest {

    companion object {
        private val alwaysMoveRule = Rule.AlwaysMoveRule()
        private val noMoveRule = Rule.NoMoveRule()
    }

    @Test
    fun `move - if isMoveAllowed in the rule is true, move once`() {
        val car = Car()
        car.move(alwaysMoveRule)

        assertEquals(1, car.moveCountInRacing)
    }

    @Test
    fun `move - if isMoveAllowed in the rule is false, do not move`() {
        val car = Car()
        car.move(noMoveRule)

        assertEquals(0, car.moveCountInRacing)
    }
}
