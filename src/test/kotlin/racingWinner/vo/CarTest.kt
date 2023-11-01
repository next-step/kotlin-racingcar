package racingWinner.vo

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import java.lang.IllegalArgumentException

class CarTest {
    @ValueSource(strings = ["Jiwon", "Alex"])
    @ParameterizedTest
    fun `자동차는 이름을 가진다`(name: String) {
        val car = Car(name)
        car.name shouldBe name
    }

    @Test
    fun `자동차의 이름은 5자를 초과하면 예외가 발생`() {
        shouldThrow<IllegalArgumentException> {
            Car("Jiwon Kwon")
        }
    }
}
