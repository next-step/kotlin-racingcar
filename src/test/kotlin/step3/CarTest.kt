package step3

import org.assertj.core.api.Java6Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.util.Random
import java.util.concurrent.ThreadLocalRandom

class CarTest {
    @Test
    fun `자동차 객체를 생성한다`() {
        assertThat(Car()).isEqualTo(Car())
    }

    @Test
    fun `자동차 객체는 움직인다`() {
        assertThat(Car(moveable = Moveable.Always()).driving()).isEqualTo(Position(1))
    }

    @Test
    fun `Position 은 음수를 가질 수 없다`() {
        assertThrows<IllegalArgumentException> { Position(-1) }
    }

    interface Moveable {
        fun moving(): Boolean

        class Always : Moveable {
            override fun moving() = true
        }

        class Random : Moveable {
            private val intRandom = IntRandom.Smart(ThreadLocalRandom.current(), BOUND_MAX)

            override fun moving(): Boolean {
                return intRandom.next() >= MOVING_MIN
            }

            companion object {
                const val BOUND_MAX = 10
                const val MOVING_MIN = 4
            }
        }
    }

    interface IntRandom {
        fun next(): Int
        class Smart(private val random: Random, private val bound: Int = Int.MAX_VALUE) :
            IntRandom {
            override fun next(): Int {
                return random.nextInt(bound)
            }
        }
    }

    data class Position(private val position: Int) {
        fun increase() = copy(position = position + 1)
    }

    class Car(private var position: Position = Position(0), private val moveable: Moveable = Moveable.Random()) {
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
