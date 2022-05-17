package car.application.dto

import car.application.vo.TryCount
import car.domain.vo.Name
import car.domain.vo.Position

data class RacingInput(
    val names: List<String>,
    val tryCount: TryCount
)

data class RapResult(
    val name: Name,
    val position: Position
)

data class RapResults(
    val results: List<RapResult>
)

data class RacingResult(
    val results: List<RapResults>,
    val winners: List<Name>
)
