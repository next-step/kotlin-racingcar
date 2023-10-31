package game.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CarFleetTest {

    private val advance = 4

    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3])
    fun `시도한 횟수 만큼 모든 자동차들을 전진시킨다`(retryCount: Int) {
        // given
        val pobi = Car.of("pobi")
        val crong = Car.of("crong")
        val honux = Car.of("honux")
        val cars = listOf(pobi, crong, honux)
        val carFleet = CarFleet.from(cars, FixedMoveConditionGenerator(advance))

        // when
        carFleet.advance(retryCount)

        // then
        assertThat(pobi.position).isEqualTo(retryCount)
        assertThat(crong.position).isEqualTo(retryCount)
        assertThat(honux.position).isEqualTo(retryCount)
    }

    @Test
    fun `자동차 이름으로 자동차들을 생성한다`() {
        // given
        val carNames = listOf("pobi", "crong", "honux")

        // when
        val carFleet = CarFleet.of(carNames, FixedMoveConditionGenerator(advance))

        // then
        assertThat(carFleet.cars.map { it.name }).containsExactly("pobi", "crong", "honux")
    }
}
