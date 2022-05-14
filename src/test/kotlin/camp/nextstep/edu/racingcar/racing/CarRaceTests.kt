package camp.nextstep.edu.racingcar.racing

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import org.assertj.core.api.Assertions.assertThat

class CarRaceTests : BehaviorSpec({
    given("자동차 엔진이 1번 움직일 수 있을 때 ") {
        val moveTwiceEngine = InstantEngine(1)
        val car = Car(1, moveTwiceEngine)

        `when`("길이가 총 5인 Track 에서 5번 달리면 ") {
            val track = Track(5)

            car.raceOn(track, 5)

            then("Track 의 흔적은 1개가 남아있어야 한다.") {
                val traces = track.traces()
                assertThat(traces.next()).isTrue
                assertThat(traces.next()).isFalse
                assertThat(traces.next()).isFalse
                assertThat(traces.next()).isFalse
                assertThat(traces.next()).isFalse
            }
        }
    }

    given("자동차 엔진이 3번 움직일 수 있을 때 ") {
        val moveTwiceEngine = InstantEngine(3)
        val car = Car(1, moveTwiceEngine)

        `when`("길이가 총 3인 Track 에서 3번 달리면 ") {
            val track = Track(3)

            car.raceOn(track, 3)

            then("Track 의 흔적은 3개가 남아있어야 한다.") {
                val traces = track.traces()
                assertThat(traces.next()).isTrue
                assertThat(traces.next()).isTrue
                assertThat(traces.next()).isTrue
            }
        }
    }

    given("자동차 엔진이 2번 움직일 수 있을 때 ") {
        val moveTwiceEngine = InstantEngine(2)
        val car = Car(1, moveTwiceEngine)

        `when`("길이가 총 3인 Track 에서 1번 달리면 ") {
            val track = Track(3)

            car.raceOn(track, 1)

            then("Track 의 흔적은 1개가 남아있어야 한다.") {
                val traces = track.traces()
                assertThat(traces.next()).isTrue
                assertThat(traces.next()).isFalse
                assertThat(traces.next()).isFalse
            }
        }
    }

    given("자동차 엔진이 5번 움직일 수 있을 때 ") {
        val moveTwiceEngine = InstantEngine(5)
        val car = Car(1, moveTwiceEngine)

        `when`("길이가 총 3인 Track 에서 5번 달리면 ") {
            val track = Track(3)

            then("IllegalStateException 이 발생해야 한다.") {
                shouldThrow<IllegalStateException> {
                    car.raceOn(track, 5)
                }
            }
        }
    }
})
