package carracing.model.service

import carracing.model.model.Racing
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class RacingServiceTest {

    private val racingService = RacingService()

    @ParameterizedTest
    @ValueSource(ints = [3, 4])
    fun `create`(numberOfCar: Int) {
        val racing = racingService.create(numberOfCar)
        assertEquals(numberOfCar, racing.cars.size)
    }

    @ParameterizedTest
    @ValueSource(ints = [0, -10])
    fun `create - if numberOfCar is not valid, throw IllegalArgumentException`(numberOfCar: Int) {
        assertThrows<IllegalArgumentException> { racingService.create(numberOfCar) }
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 5])
    fun `play`(numberOfAttempt: Int) {
        val racing = Racing(3)
        val snapshots = racingService.play(racing, numberOfAttempt)
        assertEquals(numberOfAttempt, snapshots.size)
    }

    @ParameterizedTest
    @ValueSource(ints = [0, -10])
    fun `play - if numberOfAttempt is not valid, throw IllegalArgumentException`(numberOfAttempt: Int) {
        val racing = Racing(3)
        assertThrows<IllegalArgumentException> { racingService.play(racing, numberOfAttempt) }
    }
}
