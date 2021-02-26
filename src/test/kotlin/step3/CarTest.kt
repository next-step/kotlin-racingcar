package step3

import org.assertj.core.api.Java6Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTest {
    @Test
    fun `자동차 객체를 생성한다`() {
        assertThat(Car(0)).isEqualTo(Car(0))
    }

    @Test
    fun `자동차 객체는 움직인다`() {
        assertThat(Car(0).move()).isEqualTo(Car(1))
    }

    @Test
    internal fun `자동차 객체는 Moveable을 받는다`() {
        Car(0, Moveable.Always())
    }

    interface Moveable {
        fun move(): Boolean
        class Always : Moveable {
            override fun move() = true
        }
    }

    class Car(private val position: Int, private val moveable: Moveable = Moveable.Always()) {
        fun move() = Car(position, moveable)

        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false
            return true
        }

        override fun hashCode(): Int {
            return javaClass.hashCode()
        }
    }
}
