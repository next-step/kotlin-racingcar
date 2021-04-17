package racingcar.domain

class RacingResult(val elements: List<Cars>) {

    fun winners(): Winners {
        val maxDistance = elements.last()
            .maxDistance

        return Winners(
            elements.last()
                .findAllByDistance(maxDistance)
        )
    }
}
