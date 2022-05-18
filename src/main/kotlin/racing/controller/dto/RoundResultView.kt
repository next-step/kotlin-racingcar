package racing.controller.dto

data class RoundResultView(
    val round: Int,
    val carViews: List<CarView>
)
