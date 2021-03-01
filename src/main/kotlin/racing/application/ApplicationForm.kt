package racing.application

data class ApplicationForm(
    val participants: List<String>
) {
    companion object {
        private const val APPLICATION_FORMATTER = ","

        fun write(participants: String): ApplicationForm {
            val names = participants.split(APPLICATION_FORMATTER)
            return ApplicationForm(participants = names)
        }
    }
}