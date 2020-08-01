package racing

import com.nhaarman.mockitokotlin2.spy
import com.nhaarman.mockitokotlin2.whenever
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import racing.domain.Car
import racing.domain.Cars
import racing.domain.RacingState
import racing.domain.Winner
import racing.infrastructure.RacingCar
import racing.presentation.ResultView

internal class RacingCarTest {

    @ParameterizedTest
    @MethodSource("generateStartTestData")
    fun `start() 정상 동작 테스트`(list: List<String>, expected: Int) {
        val racingState = RacingState(list, 3)
        val list = RacingCar().start(racingState)
        ResultView().show(list)
    }

    @Test
    fun `move 조건이 true 일 때, distance가 제대로 변하는지 확인`() {
        val racingState = RacingState(listOf("k3", "k5"), 3)

        val racingCar = spy(RacingCar())
        whenever(racingCar.canIMove()).thenReturn(true)

        val list = racingCar.start(racingState)

        assertThat(list.get(0).get(0).distance).isEqualTo(1)
        assertThat(list.get(0).get(1).distance).isEqualTo(1)

        assertThat(list.get(1).get(0).distance).isEqualTo(2)
        assertThat(list.get(1).get(1).distance).isEqualTo(2)

        assertThat(list.get(2).get(0).distance).isEqualTo(3)
        assertThat(list.get(2).get(1).distance).isEqualTo(3)
    }

    @Test
    fun `사용자가 입력한 자동차 수 만큼 자동차 객체가 만들어지는 테스트`() {
        // given
        val number = 4

        // when
        val carList = Car().makeCars(listOf("k3", "k5", "k7", "kona"))

        // then
        assertThat(carList.size).isEqualTo(number)
    }

    @Test
    fun `전진 조건이 false일 때 move() 호출 시 이동하지 않았음을 확인하는 테스트`() {
        var carList = mutableListOf(
            Car("k5", 0),
            Car("k7", 2)
        )

        val racingCar = spy(RacingCar())

        whenever(racingCar.canIMove()).thenReturn(false)

        racingCar.move(carList)

        assertThat(carList[0].distance).isEqualTo(0)
        assertThat(carList[1].distance).isEqualTo(2)
    }

    @Test
    fun `전진 조건이 true일 때 move() 호출 시 이동하였음을 확인하는 테스트`() {
        var carList = mutableListOf(
            Car("k5", 0),
            Car("k7", 2)
        )

        val racingCar = spy(RacingCar())

        whenever(racingCar.canIMove()).thenReturn(true)

        racingCar.move(carList)

        assertThat(carList[0].distance).isEqualTo(1)
        assertThat(carList[1].distance).isEqualTo(3)
    }

    @Test
    fun `자동차 출력시 이름과 distance가 제대로 함께 나오는지 확인`() {
        val cars1: Cars = listOf(Car("k3", 4), Car("k5", 2))
        val cars2: Cars = listOf(Car("k3", 5), Car("k5", 2))

        val list = listOf(cars1, cars2)
        ResultView().show(list)
    }

    @Test
    fun `전진 조건이 true이고 자동차가 k3, k5가 주어질 때, 각 자동차 이름별 이동거리 정상 측정`() {
        var carList = mutableListOf(
            Car("k5", 1),
            Car("k7", 0)
        )

        val racingCar = spy(RacingCar())

        whenever(racingCar.canIMove()).thenReturn(true)

        racingCar.move(carList)

        assertThat(carList[0].name).isEqualTo("k5")
        assertThat(carList[0].distance).isEqualTo(2)
        assertThat(carList[1].name).isEqualTo("k7")
        assertThat(carList[1].distance).isEqualTo(1)
    }

    @Test
    fun `sortedByDistanceDesc로 정렬된 데이터에 대하여 longestDistance 호출 시 가장 긴 거리가 나오는지 확인`() {
        var car1 = Car("k7", 5)
        var car2 = Car("k5", 3)
        var car3 = Car("k3", 1)

        val cars: Cars = listOf(car1, car2, car3)

        assertThat(RacingCar().longestDistance(cars)).isEqualTo(car1.distance)
    }

    @Test
    fun `가장 많이 움직인 차가 1대 일 때 우승자 목록을 가져오면 우승자가 한명이어야 한다`() {
        var car1 = Car("k5", 2)
        var car2 = Car("k7", 5)
        var car3 = Car("k3", 1)

        val cars: Cars = listOf(car1, car2, car3)

        val winners = Winner().get(listOf(cars))

        assertThat(winners).size().isEqualTo(1)
        assertThat(winners[0].name).isEqualTo(car2.name)
    }

    @Test
    fun `가장 많이 움직인 차가 2대 일 때 우승자 목록을 가져오면 우승자가 2명이어야 한다`() {
        var car1 = Car("k5", 2)
        var car2 = Car("k7", 5)
        var car3 = Car("k3", 5)

        val cars: Cars = listOf(car1, car2, car3)

        val winners = Winner().get(listOf(cars))

        assertThat(winners).size().isEqualTo(2)
        assertThat(winners[0].name).isEqualTo(car2.name)
        assertThat(winners[1].name).isEqualTo(car3.name)
    }

    companion object {
        @JvmStatic
        fun generateStartTestData(): List<Arguments> {
            return listOf(
                Arguments.of(listOf("k3", "k5"), 3)
            )
        }
    }
}
