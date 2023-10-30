package game.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource
import java.util.stream.Stream

class CarFleetTest {

    private val advance = 4

    @ParameterizedTest
    @MethodSource("winner")
    fun `자동차들에서 우승자를 찾는다`(pobiCount: Int, crongCount: Int, honuxCount: Int, expected: List<String>) {
        // given
        val pobi = Car.of("pobi", pobiCount)
        val crong = Car.of("crong", crongCount)
        val honux = Car.of("honux", honuxCount)

        val cars = listOf(pobi, crong, honux)
        val carFleet = CarFleet.of(cars)

        // when
        val actual = carFleet.findWinner()

        // then
        assertThat(actual).containsExactlyElementsOf(expected)
    }

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

    companion object {

        @JvmStatic
        fun winner(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(2, 2, 1, listOf("pobi", "crong")),
                Arguments.of(1, 2, 3, listOf("honux")),
                Arguments.of(1, 1, 1, listOf("pobi", "crong", "honux")),
            )
        }
    }
}
