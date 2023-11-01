package carracing.model.service

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class RacingServiceTest {

    val racingServcie = RacingService()

    @ParameterizedTest
    @ValueSource(ints = [3, 4])
    fun `create`(numberOfCar: Int) {
        val racing = racingServcie.create(numberOfCar)
        assertEquals(numberOfCar, racing.cars.size)
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 5])
    fun `play`() {
    }
}