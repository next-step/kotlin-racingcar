package onestep.racingcar.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class RacingTest {

    @Test
    fun `Should be EqualTo, CarNames's Size And racing's Car's Size`() {
        // given : 3 CarName , 3 Try
        val racing = Racing(listOf("CAR1", "CAR2", "CAR3"), 3)
        // when : race
        // then : CarNameCount = racingCar size ,And Winner is Not Empty
        racing.race {
            Assertions.assertThat(it.size).isEqualTo(3)
        }.run {
            Assertions.assertThat(this).isNotEmpty
        }
    }

    @Test
    fun `Should not be Empty, When CarCount's Input Greater than 0`() {
        // given
        val racing = Racing(listOf("CAR1", "CAR2", "CAR3"), 3)
        // when
        // then
        racing.race {
            Assertions.assertThat(it).isNotEmpty
        }
    }

    @Test
    fun `Should be Empty, When CarCount's Input is 0`() {
        // given : 0 CarName , 3 Try
        val racing = Racing(listOf(), 3)
        // when
        // then
        racing.race {
            Assertions.assertThat(it).isEmpty()
        }
    }

    @Test
    fun `Should return empty Winner, When Zero Car`() {
        // given : 0 Cars , 8 Try
        val racing = Racing(listOf(), 8)
        // when
        // then : Winner is Empty
        racing.race { }.run {
            Assertions.assertThat(this.size).isEqualTo(0)
        }
    }

    @Test
    fun `Should return Winner, When only One winner`() {
        // given : 1 Cars , 8 Try
        val racing = Racing(listOf("CAR1"), 8)
        // when
        // then : Winner is only One
        racing.race { }.run {
            Assertions.assertThat(this.size).isEqualTo(1)
        }
    }

    @Test
    fun `Should return Winners, When winners are 2 or more`() {
        // given : 3 Cars , 0 Try
        val racing = Racing(listOf("CAR1", "CAR2", "CAR3"), 0)
        // when
        // then : Winner is 3 Cars
        racing.race { }.run {
            Assertions.assertThat(this.size).isEqualTo(3)
        }
    }
}
