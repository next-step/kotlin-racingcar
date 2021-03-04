package racinggame.record.domain

import racinggame.car.domain.RacingCar
import racinggame.record.dto.Record

class Recorder(val records: MutableList<Records>) {
    fun record(cars: List<RacingCar>, time: Int) {
        this.records.add(cars.toRecords(time))
    }

    fun getWinners(): List<Record> {
        if (records.isNullOrEmpty()) {
            throw IllegalArgumentException("녹화된 기록이 없습니다.")
        }
        return records.maxBy { it.getTime() }!!.findWinners()
    }

    companion object {
        fun create() = Recorder(mutableListOf())
    }
}

private fun Iterable<RacingCar>.toRecords(time: Int): Records {
    val list = map { Record(time, it.name, it.distance) }
        .toList()
    return Records(list)
}
