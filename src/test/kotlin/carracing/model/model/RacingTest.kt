package carracing.model.model

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.RepeatedTest
import org.junit.jupiter.api.Test
import kotlin.random.Random

class RacingTest {


    companion object {
        private val alwaysMoveRule = Rule.AlwaysMoveRule()
        private val noMoveRule = Rule.NoMoveRule()
    }

    @Test
    fun `progress - every car move once`() {
        val numberOfCar = 4
        val racing = Racing(numberOfCar, alwaysMoveRule)

        racing.progress()

        racing.cars.forEach {
            assertEquals(1, racing.locations[it])
        }
    }

    @RepeatedTest(10)
    fun `takeSnapshot - create a snapshot object`() {
        val numberOfCar = Random.nextInt(1, 10)
        val racing = Racing(numberOfCar)

        val snapshot = racing.takeSnapshot()

        assertNotNull(snapshot)
    }
}
