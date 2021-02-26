package step3

import org.assertj.core.api.Java6Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTest {
    @Test
    fun `자동차 객체를 생성한다`() {
        assertThat(Car()).isEqualTo(Car())
    }

    @Test
    fun `자동차 객체는 움직인다`() {
        assertThat(Car().driving()).isEqualTo(Position(1))
    }

    @Test
    fun `자동차 객체는 Moveable을 받는다`() {
        Car()
    }

    interface Moveable {
        fun moving(): Boolean
        class Always : Moveable {
            override fun moving() = true
        }
    }

    data class Position(private val position: Int) {
        fun increase() = copy(position = position + 1)
    }

    class Car(private var position: Position = Position(0), private val moveable: Moveable = Moveable.Always()) {
        fun driving(): Position {
            if (moveable.moving()) {
                position = position.increase()
            }
            return position
        }

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
