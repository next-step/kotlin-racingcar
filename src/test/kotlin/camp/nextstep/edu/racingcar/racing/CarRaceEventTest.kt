package camp.nextstep.edu.racingcar.racing

import camp.nextstep.edu.racingcar.racing.CarRaceEvent.Companion.merge
import io.kotest.core.spec.style.BehaviorSpec
import org.assertj.core.api.Assertions.assertThat

class CarRaceEventTest : BehaviorSpec({
    given("자동차 엔진이 1번 움직일 수 있을 때 ") {
        val moveOnceEngine = InstantEngine(1)
        val car = Car(1, "once", moveOnceEngine)

        `when`("자동차가 5번 달리면 ") {
            val events = mutableListOf<CarRaceEvent>()

            events.add(car.race())
            events.add(car.race())
            events.add(car.race())
            events.add(car.race())
            events.add(car.race())

            then("Track 에 흔적이 1개 남아있어야 한다.") {
                val traces = events.merge().traces().iterator()
                assertThat(traces.next()).isTrue
                assertThat(traces.next()).isFalse
                assertThat(traces.next()).isFalse
                assertThat(traces.next()).isFalse
                assertThat(traces.next()).isFalse
            }
        }
    }

    given("자동차 엔진이 3번 움직일 수 있을 때 ") {
        val moveThirdEngine = InstantEngine(3)
        val car = Car(1, "third", moveThirdEngine)

        `when`("자동차가 3번 달리면 ") {
            val events = mutableListOf<CarRaceEvent>()

            events.add(car.race())
            events.add(car.race())
            events.add(car.race())

            then("Track 의 흔적은 3개가 남아있어야 한다.") {
                val traces = events.merge().traces().iterator()
                assertThat(traces.next()).isTrue
                assertThat(traces.next()).isTrue
                assertThat(traces.next()).isTrue
            }
        }
    }
})
