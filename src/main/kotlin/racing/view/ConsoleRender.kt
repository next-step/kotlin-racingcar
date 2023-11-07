package racing.view

import racing.model.Car
import racing.model.RoundHistory

object ConsoleRender {

    fun roundRendering(roundHistory: RoundHistory): String {
        return roundHistory
            .results
            .joinToString(separator = "\n") { carRendering(it) }
    }

    private fun carRendering(car: Car): String {
        return "${car.name.value} : ${distanceRendering(car)}"
    }

    private fun distanceRendering(car: Car): String {
        return "-".repeat(car.position)
    }
}
