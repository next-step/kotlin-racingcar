package step4

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTest {

    @Test
    fun `자동차 생성 테스트`() {
        val car = Car("test")
        assertThat(car.getPosition()).isEqualTo(1)
        assertThat(car.name).isEqualTo("test")
        assertThat(car.getCarStatus()).isEqualTo("test  : -")
    }

    @Test
    fun `자동차 전진 테스트`() {
        val car = Car(
            "test",
            object : ForwardDecider {
                override fun execute(): Boolean {
                    return true
                }
            }
        )
        repeat(10) {
            car.doForwardOrNot()
        }
        assertThat(car.getPosition()).isEqualTo(11)
        assertThat(car.getCarStatus()).isEqualTo("test  : -----------")
    }

    @Test
    fun `자동차 정지 테스트`() {
        val car = Car(
            "test",
            object : ForwardDecider {
                override fun execute(): Boolean {
                    return false
                }
            }
        )
        repeat(10) {
            car.doForwardOrNot()
        }
        assertThat(car.getPosition()).isEqualTo(1)
        assertThat(car.getCarStatus()).isEqualTo("test  : -")
    }
}
