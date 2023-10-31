package racing.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

internal class LocationTest {
    @Test
    fun 위치값_생성시_0으로_설정() {
        val location = Location()
        Assertions.assertThat(location).isEqualTo(Location(0))
    }

    @Test
    fun 위치값_증가시_1만큼_증가() {
        val location = Location()
        val addedLocation = location.add()
        Assertions.assertThat(addedLocation).isEqualTo(Location(1))
    }
}
