data class Person( // data class => lombok @Data
    val name: String,
    val age: Int? = null, // ? null 허용
    var nickname: String? = null
)
