package onestep.racingcar.model

import onestep.racingcar.model.engine.CarEngine
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class CarTest {

    class FakeCarEngine(val input: () -> Int) : CarEngine {
        override fun run() = input()
    }

    @Test
    fun `Happy Case`() {
        Car(engine = FakeCarEngine { 3 }).apply {
            run()
        }.also {
            Assertions.assertThat(it.printPosition()).isEqualTo("---")
        }

        Car(engine = FakeCarEngine { 0 }).apply {
            run()
        }.also {
            Assertions.assertThat(it.printPosition()).isEqualTo("")
        }
    }
}
