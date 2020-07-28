package racing

import com.nhaarman.mockitokotlin2.spy
import com.nhaarman.mockitokotlin2.whenever
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racing.Infrastructure.RacingCar
import racing.domain.Car
import racing.domain.Cars
import racing.domain.RacingState
import racing.presentation.ResultView

internal class RacingCarTest {

    @Test
    fun `start() 정상 동작 테스트`() {
        val racingState = RacingState(listOf("k3", "k5"), 3)
        val list = RacingCar().start(racingState)
        ResultView().view(list)
    }

    @Test
    fun `move 조건이 true 일 때, distance가 제대로 변하는지 확인`() {
        val racingState = RacingState(listOf("k3", "k5"), 3)

        val racingCar = spy(RacingCar())
        whenever(racingCar.canIMove()).thenReturn(true)

        val list = racingCar.start(racingState)

        assertThat(list.get(0).get(0).distance).isEqualTo("-")
        assertThat(list.get(0).get(1).distance).isEqualTo("-")

        assertThat(list.get(1).get(0).distance).isEqualTo("--")
        assertThat(list.get(1).get(1).distance).isEqualTo("--")

        assertThat(list.get(2).get(0).distance).isEqualTo("---")
        assertThat(list.get(2).get(1).distance).isEqualTo("---")
    }

    @Test
    fun `사용자가 입력한 자동차 수 만큼 자동차 객체가 만들어지는 테스트`() {
        // given
        val number = 4

        // when
        val carList = RacingCar().makeCarList(RacingState(listOf("k3", "k5", "k7", "kona")))

        // then
        assertThat(carList.size).isEqualTo(number)
    }

    @Test
    fun `전진 조건이 false일 때 move() 호출 시 이동하지 않았음을 확인하는 테스트`() {
        var carList = mutableListOf(
            Car("k5", ""),
            Car("k7", "--")
        )

        val racingCar = spy(RacingCar())

        whenever(racingCar.canIMove()).thenReturn(false)

        racingCar.move(carList)

        assertThat(carList[0].distance).isEqualTo("")
        assertThat(carList[1].distance).isEqualTo("--")
    }

    @Test
    fun `전진 조건이 true일 때 move() 호출 시 이동하였음을 확인하는 테스트`() {
        var carList = mutableListOf(
            Car("k5", ""),
            Car("k7", "--")
        )

        val racingCar = spy(RacingCar())

        whenever(racingCar.canIMove()).thenReturn(true)

        racingCar.move(carList)

        assertThat(carList[0].distance).isEqualTo("-")
        assertThat(carList[1].distance).isEqualTo("---")
    }

    @Test
    fun `자동차 출력시 이름과 distance가 제대로 함께 나오는지 확인`() {
        val cars1: Cars = listOf(Car("k3", "----"), Car("k5", "--"))
        val cars2: Cars = listOf(Car("k3", "-----"), Car("k5", "--"))

        val list = listOf(cars1, cars2)
        ResultView().view(list)
    }

    @Test
    fun `전진 조건이 true이고 자동차가 k3, k5가 주어질 때, 각 자동차 이름별 이동거리 정상 측정`() {
        var carList = mutableListOf(
            Car("k5", "-"),
            Car("k7", "")
        )

        val racingCar = spy(RacingCar())

        whenever(racingCar.canIMove()).thenReturn(true)

        racingCar.move(carList)

        assertThat(carList[0].name).isEqualTo("k5")
        assertThat(carList[0].distance).isEqualTo("--")
        assertThat(carList[1].name).isEqualTo("k7")
        assertThat(carList[1].distance).isEqualTo("-")
    }

    @Test
    fun `racing 이후 결과에 대하여 sortedByDistanceDesc 호출 시 장거리 기준으로 정렬됐는지 확인`() {
        var car1 = Car("k3", "-")
        var car2 = Car("k5", "---")

        val cars: Cars = listOf(car1, car2)
        val sortedByDistanceDesc = RacingCar().sortedByDistanceDesc(cars)

        assertThat(sortedByDistanceDesc).element(0).isEqualTo(car2)
        assertThat(sortedByDistanceDesc).element(1).isEqualTo(car1)
    }

    @Test
    fun `sortedByDistanceDesc로 정렬된 데이터에 대하여 longestDistance 호출 시 가장 긴 거리가 나오는지 확인`() {
        var car1 = Car("k7", "-----")
        var car2 = Car("k5", "---")
        var car3 = Car("k3", "-")

        val cars: Cars = listOf(car1, car2, car3)

        assertThat(RacingCar().longestDistance(cars)).isEqualTo(car1.distance)
    }

    @Test
    fun `우승자가 1명일 때 우승자 1명이 제대로 출력되는지 확인`() {
        var car1 = Car("k5", "--")
        var car2 = Car("k7", "-----")
        var car3 = Car("k3", "-")

        val cars: Cars = listOf(car1, car2, car3)

        val winners = RacingCar().getWinner(listOf(cars))

        assertThat(winners).size().isEqualTo(1)
        assertThat(winners[0].name).isEqualTo(car2.name)
    }

    @Test
    fun `우승자가 2명일 때 우승자 2명이 제대로 출력되는지 확인`() {
        var car1 = Car("k5", "--")
        var car2 = Car("k7", "-----")
        var car3 = Car("k3", "-----")

        val cars: Cars = listOf(car1, car2, car3)

        val winners = RacingCar().getWinner(listOf(cars))

        assertThat(winners).size().isEqualTo(2)
        assertThat(winners[0].name).isEqualTo(car2.name)
        assertThat(winners[1].name).isEqualTo(car3.name)
    }
}
