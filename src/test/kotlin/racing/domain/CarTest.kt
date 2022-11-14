package racing.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racing.domain.strategy.RandomMovingStrategy
import java.io.ByteArrayOutputStream
import java.io.PrintStream

internal class CarTest {
    private val standardOut: PrintStream = System.out
    private val outputStreamCaptor: ByteArrayOutputStream = ByteArrayOutputStream()

    private lateinit var car: Car

    @BeforeEach
    fun setUp() {
        car = Car("test", RandomMovingStrategy)
        System.setOut(PrintStream(outputStreamCaptor))
    }

    @ParameterizedTest
    @ValueSource(strings = ["", "  "])
    fun `자동차 이름을 공백으로 생성하면, IllegalArgumentException`(name: String) {
        assertThrows<IllegalArgumentException> { Car(name, RandomMovingStrategy) }
    }

    @Test
    fun `자동차 이름을 제한 길이 이상으로 생성하면, IllegalArgumentException`() {
        val name = "A".repeat(Car.NAME_MAX_LENGTH + 1)
        assertThrows<IllegalArgumentException> { Car(name, RandomMovingStrategy) }
    }

    @Test
    fun `자동차 최초 position은 0이다`() {
        assertThat(car.position).isZero
    }

    @AfterEach
    fun tearDown() {
        System.setOut(standardOut)
    }
}
