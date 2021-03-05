package racingcar_winner.model

import racingcar_winner.util.progressNumberToBar

class Recorder {

    var record: String = ""
        private set

    fun writeRecord(cars: Cars) {
        cars.toList().forEach { car ->
            record += convertCarToProgress(car)
        }
        record += "\n"
    }

    private fun convertCarToProgress(car : Car): String {
        return "${car.name} : ${car.progress.progressNumberToBar()}\n"
    }
}
