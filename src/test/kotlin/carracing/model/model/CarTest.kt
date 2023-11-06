package carracing.model.model

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CarTest {

    companion object {
        private val alwaysMoveRule = Rule.AlwaysMoveRule()
        private val noMoveRule = Rule.NoMoveRule()
    }

    @Test
    fun `move - if isMoveAllowed in the rule is true, move once`() {
        val car = Car(0)
        assertEquals(1, car.move(alwaysMoveRule))
        assertEquals(0, car.move(noMoveRule))
    }
}