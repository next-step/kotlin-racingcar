package racing.view

import racing.model.Car
import racing.model.RoundHistory

object ConsoleRender {

    fun roundRendering(roundHistory: RoundHistory): String {
        return roundHistory.results
            .map { carRendering(it) }
            .joinToString(separator = "\n")
    }

    private fun carRendering(car: Car): String {
        return String.format("%s : %s", car.name, distanceRendering(car))
    }

    private fun distanceRendering(car: Car): String {
        return "-".repeat(car.position)
    }
}
