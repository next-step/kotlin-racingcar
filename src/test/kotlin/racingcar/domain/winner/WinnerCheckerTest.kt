package racingcar.domain.winner

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.domain.WinnerChecker
import racingcar.domain.Car

class WinnerCheckerTest {

    @Test
    fun `findWinners() 우승자가 한명인 경우`() {
        assertThat(
            WinnerChecker().findWinners(
                cars = listOf(
                    Car("1", 5),
                    Car("2", 3),
                    Car("3", 1)
                )
            )
        ).isEqualTo(
            listOf(Car("1", 5))
        )
    }

    @Test
    fun `findWinners() 우승자가 여러명인 경우`() {
        assertThat(
            WinnerChecker().findWinners(
                cars = listOf(
                    Car("1", 5),
                    Car("2", 5),
                    Car("3", 5)
                )
            )
        ).isEqualTo(
            listOf(
                Car("1", 5),
                Car("2", 5),
                Car("3", 5)
            )
        )
    }

    @Test
    fun `findWinners() 전부다 움직인 적 없는 경우`() {
        assertThat(
            WinnerChecker().findWinners(
                cars = listOf(
                    Car("1", 0),
                    Car("2", 0),
                    Car("3", 0)
                )
            )
        ).isEqualTo(
            listOf(
                Car("1", 0),
                Car("2", 0),
                Car("3", 0)
            )
        )
    }

    @Test
    fun `findWinners() 차가 없는 경우`() {
        assertThat(
            WinnerChecker().findWinners(
                cars = listOf()
            )
        ).isEqualTo(
            listOf<Car>()
        )
    }

    @Test
    fun `sortByDistance() 이동거리가 큰 순으로 정렬`() {
        WinnerChecker().apply {
            assertThat(
                listOf(
                    Car("1", 1),
                    Car("2", 3),
                    Car("3", 5)
                )
                    .sortByDistance()
            )
                .isEqualTo(
                    listOf(
                        Car("3", 5),
                        Car("2", 3),
                        Car("1", 1)
                    )
                )
        }
    }

    @Test
    fun `filterAllFirst() 리스트의 첫번째 차의 거리와 같은 차들만 앞에서부터 필터링`() {
        // 테스트 함수 이름이 직관적이지 않아서 부연 설명을 하자면
        // 이미 정렬된 리스트의 경우 첫번째가 가장 큰 값을 가지고 있으므로
        // takeWhile로 앞에서부터 첫번째 원소와 다른 값을 가진 원소가 나올 때까지 추출한다.
        WinnerChecker().apply {
            assertThat(
                listOf(
                    Car("1", 3),
                    Car("2", 3),
                    Car("3", 1)
                )
                    .filterAllFirst()
            )
                .isEqualTo(
                    listOf(
                        Car("1", 3),
                        Car("2", 3)
                    )
                )
        }
    }
}
