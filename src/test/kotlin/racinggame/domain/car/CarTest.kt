package racinggame.domain.car

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racinggame.domain.engine.Engine

class CarTest {
    @Test
    fun `Car 클래스는 자동차의 이름을 보관한다`() {
        val car = Car("pobi") { 1 }

        assertThat(car.name).isEqualTo("pobi")
    }

    @Test
    fun `proceed를 통해 Engine에서 정하는 거리 만큼 Car의 proceedLevel을 높일 수 있다`() {
        val car = Car("") { 1 }

        car.proceed()
        assertThat(car.proceedLevel).isEqualTo(1)

        car.proceed()
        assertThat(car.proceedLevel).isEqualTo(2)
    }

    @Test
    fun `한 번 사용하면 고장나는 Engine을 넣은 Car는 처음 한 번만 proceedLevel이 증가한다`() {
        val car = Car(
            "",
            object : Engine {
                var isBroken = false

                override fun getMovableDistance(): Int {
                    return (if (isBroken) 0 else 10).also {
                        isBroken = true
                    }
                }
            }
        )

        car.proceed()
        assertThat(car.proceedLevel).isEqualTo(10)

        car.proceed()
        assertThat(car.proceedLevel).isEqualTo(10)
    }
}
