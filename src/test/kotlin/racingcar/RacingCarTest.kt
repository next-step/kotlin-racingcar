package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.domain.Car
import racingcar.domain.Cars
import racingcar.domain.Position
import racingcar.domain.Record

class RacingCarTest {

    private lateinit var record: Record

    @BeforeEach
    internal fun setUp() {
        record = Record()
    }

    @Test
    fun `자동차의 초기 위치는 0이다`() {
        val car = Car()
        assertThat(car.getPosition()).isEqualTo(0)
    }

    @Test
    fun `자동차를 앞으로 이동할 수 있다`() {
        // given
        val car = Car(Position(0), FixMoveStrategy())
        // when
        val actual = car.dashOver()
        // then
        assertThat(actual.getPosition()).isEqualTo(1)
    }

    @ParameterizedTest
    @ValueSource(ints = [4])
    fun `요청한 갯수만큼 자동차를 생성한다`(givenCount: Int) {
        val cars = Cars(givenCount)

        assertThat(cars.size()).isEqualTo(givenCount)
    }

    @Test
    fun `자동차 목록을 이동하면 변경된 자동차 목록을 리턴한다`() {
        // given
        val cars = Cars(0, listOf(Car(), Car()))

        val actual = cars.dashOver()

        assertThat(actual).isNotSameAs(cars)
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 2])
    fun `값을 입력받아 위치를 생성할 수 있다`(givenValue: Int) {
        assertThat(Position(givenValue)).isNotNull
    }

    @Test
    fun `자동차 목록을 기록하고 크기를 리턴한다`() {
        record.add(1, Cars(0))
        record.add(2, Cars(0))

        assertThat(record.getSize()).isEqualTo(2)
    }

    @Test
    fun `자동차 목록의 데이터를 리턴한다`() {
        // given
        val givenCars = Cars(0)
        record.add(1, givenCars)
        // when
        val actual = record.getRecord(1)
        // then
        assertThat(actual).isEqualTo(givenCars)
    }
}
