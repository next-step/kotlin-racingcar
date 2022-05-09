package step3.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import step3.domain.Engine

class CarTest {
    @Test
    fun `proceed를 통해 Engine에서 정하는 거리 만큼 Car의 proceedLevel을 높일 수 있다`() {
        val car1 = Car { 1 }
        car1.proceed()
        assertThat(car1.proceedLevel).isEqualTo(1)

        car1.proceed()
        assertThat(car1.proceedLevel).isEqualTo(2)

        val car2 = Car(
            object : Engine {
                var isBroken = false

                override fun getMovableDistance(): Int {
                    return (if (isBroken) 0 else 10).also {
                        isBroken = true
                    }
                }
            }
        )

        car2.proceed()
        assertThat(car2.proceedLevel).isEqualTo(10)
        car2.proceed()
        assertThat(car2.proceedLevel).isEqualTo(10)
    }
}
