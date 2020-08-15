package onestep.racingcar.domain

import onestep.racingcar.domain.engine.CarEngine
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.catchThrowable
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CarTest {

    class FakeCarEngine(val input: () -> Int) : CarEngine {
        override fun run() = input()
    }

    @ParameterizedTest
    @ValueSource(ints = [5, 4, 3, 2, 1])
    fun `Should position inputCount, When input inputCount EnginePower `(input: Int) {
        // given : Car's Engine Power is 3
        val car = Car(engine = FakeCarEngine { input })
        // when : car try run 1 time
        car.run()
        // then : car.position is 3
        assertThat(car.position).isEqualTo(input)
    }

    @Test
    fun `Should position 0, When input 0 EnginePower And Just 1 Try`() {
        // given : Car's Engine Power is 0
        val carEngine0 = Car(engine = FakeCarEngine { 0 })
        // when : car try run 1 time
        carEngine0.run()
        // then : car.position is 0
        assertThat(carEngine0.position).isEqualTo(0)
    }

    @Test
    fun `Should Throws Exception , When CarName's length bigger than 5`() {
        // given : Car name is bigger than 5
        val carName = "CARCARCARCAR"
        // when : createCar
        // then : Throws Exception("CarName's Length can not more than 5")
        catchThrowable {
            Car.newInstance(carName)
        }
    }
}
