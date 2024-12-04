package racing.model

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class CarTest {
    @Test
    fun `주어진 횟수 동안 n대의 자동차는 4미만인 경우 멈춘다`() {
        val engine = IntRangeEngineFactory.create(0..3)
        val car = Car("", engine)
        car.move()
        car.position shouldBe 0
    }

    @Test
    fun `주어진 횟수 동안 n대의 자동차는 4이상인 경우 전진한다`() {
        val engine = IntRangeEngineFactory.create(4..9)
        val car = Car("", engine)
        car.move()
        car.position shouldBe 1
    }

    @ParameterizedTest
    @CsvSource("0", "1", "2", "3")
    fun `주어진 횟수 동안 n대의 자동차는 4미만인 경우 멈춘다 2`(
        fixedValue: Int
    ) {
        val engine = FixedEngine(fixedValue)
        val car = Car("", engine)
        car.move()
        car.position shouldBe 0
    }

    @ParameterizedTest
    @CsvSource("4", "5", "6", "7", "8", "9")
    fun `주어진 횟수 동안 n대의 자동차는 4이상인 경우 전진한다2`(
        fixedValue: Int
    ) {
        val engine = FixedEngine(fixedValue)
        val car = Car("", engine)
        car.move()
        car.position shouldBe 1
    }
}
