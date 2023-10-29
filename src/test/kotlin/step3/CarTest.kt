package step3

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTest {

    @Test
    fun `자동차 생성 테스트`() {
        val car = Car()
        assertThat(car.getPosition()).isEqualTo(1)
    }

    @Test
    fun `자동차 전진 테스트`() {
        val car = Car(object : ForwardDecider {
            override fun execute(): Boolean {
                return true
            }
        })
        repeat(10) {
            car.doForwardOrNot()
        }
        assertThat(car.getPosition()).isEqualTo(11)
    }

    @Test
    fun `자동차 정지 테스트`() {
        val car = Car(object : ForwardDecider {
            override fun execute(): Boolean {
                return false
            }
        })
        repeat(10) {
            car.doForwardOrNot()
        }
        assertThat(car.getPosition()).isEqualTo(1)
    }
}
