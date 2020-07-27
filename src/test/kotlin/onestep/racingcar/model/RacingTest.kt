package onestep.racingcar.model

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class RacingTest {

    @Test
    fun `Should be EqualTo, CarNames's Size And racing's Car's Size`() {
        // given : 3 CarName , 3 Try
        val racing = Racing(listOf("CAR1", "CAR2", "CAR3"), 3)
        // when : race
        // then : CarNameCount = racingCar size
        racing.race {
            Assertions.assertThat(it).isEqualTo(3)
        }
    }

    @Test
    fun `Should not be Empty, When CarCount's Input Greater than 0`() {
        // given : 3 CarName , 3 Try
        val racing = Racing(listOf("CAR1", "CAR2", "CAR3"), 3)
        // when : race
        // then : racingCar is Not Empty
        racing.race {
            Assertions.assertThat(it).isNotEmpty
        }
    }

    @Test
    fun `Should be Empty, When CarCount's Input is 0`() {
        // given : 0 CarName , 3 Try
        val racing = Racing(listOf(), 3)
        // when : race
        // then : racingCar is Empty
        racing.race {
            Assertions.assertThat(it).isEmpty()
        }
    }

    fun `Should return Winner, When only one winner`() {
        return
    }

    fun `Should return Winners, When winners are 2 or more`() {
        return
    }
}
