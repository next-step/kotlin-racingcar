package study.step3

import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.assertions.throwables.shouldThrow
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import study.step3.entity.Car
import study.step3.entity.Engine

class CarTest {
    private lateinit var engine: Engine

    @BeforeEach
    fun setUp() {
        engine = Engine()
    }

    @ValueSource(strings = ["dino", "dino2"])
    @ParameterizedTest
    fun `자동차 이름은 5자 이하 입니다`(carName: String) {
        shouldNotThrow<IllegalStateException> {
            Car(name = carName, engine = engine)
        }
    }

    @ValueSource(strings = ["dino11", "dino22"])
    @ParameterizedTest
    fun `자동차 이름이 5자를 초과하면 throw`(carName: String) {
        shouldThrow<IllegalStateException> {
            Car(name = carName, engine = engine)
        }
    }
}
