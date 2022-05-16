package camp.nextstep.edu.racingcar.racing

import java.util.concurrent.atomic.AtomicLong

/**
 * (언제) 어떤 차가 움직였는지에 대한 이벤트
 *
 * @property eventId 이벤트 아이디 (오름차순으로 생성)
 * @property carId 어떤 차가
 * @property moved 움직였는지
 */
class CarRaceEvent private constructor(val eventId: Long, val carId: Int, val moved: Boolean) {

    companion object {
        private val idGenerator = AtomicLong(0L)

        fun movedEvent(carId: Int) = CarRaceEvent(idGenerator.getAndIncrement(), carId, true)

        fun stoppedEvent(carId: Int) = CarRaceEvent(idGenerator.getAndIncrement(), carId, false)

        fun merge(events: List<CarRaceEvent>): Track {
            require(events.isNotEmpty())
            check(events.all { events[0].carId == it.carId }) { "하나의 자동차에 대한 이벤트만 연산할 수 있습니다. " }

            val track = Track(events.size)
            for (event in events.sortedBy { it.eventId }) {
                if (event.moved) track.markTrace()
            }
            return track
        }
    }
}
