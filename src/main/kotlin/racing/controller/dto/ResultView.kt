package racing.controller.dto

data class ResultView(
    val winners: List<String>,
    val roundResultViews: List<RoundResultView>
)
