package racing

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTest {
    
    @Test
    fun `자동차의 첫 위치는 0이다`() {
        val car = object : Car() {
            override fun moveOrNot(): Boolean {
                return true
            }
        }

        assertThat(car.position).isEqualTo(0)
    }

    @Test
    fun `랜덤 결과 움직이는 경우`() {
        val car = object : Car() {
            override fun moveOrNot(): Boolean {
                return true
            }
        }
        
        car.move()
        assertThat(car.position).isEqualTo(1)
    }

    @Test
    fun `랜덤 결과 안 움직이는 경우`() {
        val car = object : Car() {
            override fun moveOrNot(): Boolean {
                return false
            }
        }
        
        car.move()
        assertThat(car.position).isEqualTo(0)
    }
}
