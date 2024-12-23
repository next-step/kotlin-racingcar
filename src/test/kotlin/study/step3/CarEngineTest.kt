package study.step3

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import study.step3.entity.CarEngine
import study.step3.entity.Mileage

class CarEngineTest {
    private lateinit var carEngine: CarEngine

    @BeforeEach
    fun setUp() {
        carEngine = CarEngine(minPerToMove = 4)
    }

    @ParameterizedTest
    @CsvSource(
        value = [
            "0, 0",
            "1, 0",
            "2, 0",
            "3, 0",
            "4, 1",
            "5, 1",
            "6, 1",
            "7, 1",
            "8, 1",
            "9, 1",
        ]
    )
    internal fun `4 이상인 경우 움직일 수 있는지`(rpm: Int, expected: Int) {
        carEngine.accelerate(rpm) shouldBe Mileage(expected)
    }
}
