package main.kotlin.ifelsewhen

fun ifelsewhen() {
    // 조건문
    // 사용 방법은 똑같다.
    // if, else if, else
    // when

    val dust: Int = 30
    if (dust <= 15) {
        println("좋음")
    } else if (dust <= 45) {
        println("보통")
    } else if (dust <= 75) {
        println("나쁨")
    } else {
        println("매우 나쁨")
    }

    ///////////////////////////////////////

    // when 을 사용하면 가독성을 향상시킬 수 있음.
    // enum class 랑 조합해서 같이 쓰면 금상첨화
    val dust2: Int = 78
    when (dust2) {
        in 0..15 -> {
            println("좋음")
        }
        in 16..45 -> {
            println("보통")
        }
        in 46..75 -> {
            println("나쁨")
        }
        80 -> {
            println("지정한 수치 80 입니다.")
        }
        else -> {
            println("매우 나쁨")
        }
    }
}