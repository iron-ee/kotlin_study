package main.kotlin.ifelsewhen


// Statement : 프로그램의 문장, 하나의 값으로 도출되지 않는다.
// Expression : 하나의 값으로 도출되는 문장
// java 에서는 expression 이 적용되지 않아서 삼항연산자를 사용했지만
// kotlin 에서는 expression 이 허용되기 때문에 삼항연산자가 없음.

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
        in 0..15 -> println("좋음")
        in 16..45 -> println("보통")
        in 46..75 -> println("나쁨")
        80 -> println("지정한 수치 80 입니다.")
        else -> println("매우 나쁨")
    }
}

fun getString (score: Int) {
    return when (score / 10) {
        9 -> print("df")
        8 -> print("df")
        else -> print("df")
    }
}

fun startsWithA(obj: Any): Boolean {
    return when (obj) {
        is String -> obj.startsWith("A")    // 어떠한 expression 이라도 들어갈 수 있음.
        else -> false
    }
}

fun judgeNumber(number: Int) {
    return when (number) {
        1, 0, -1 -> println("어디서 많이 본 숫자입니다.")  // 여러개의 조건을 동시에 검사할 수 있다. (,로 구분)
        else -> println("1, 0, -1 도 아닙니다.")
    }
}

fun judgeNumber2(number: Int) {
    when {  // when 에 주어진 값이 없을수도 있다 -> early return 처럼 동작
        number == 0 -> print("주어진 숫자는 0 입니다.")
        number % 2 == 0 -> print("주어진 숫자는 짝수입니다.")
        else -> println("주어지는 숫자는 홀수 입니다.")
    }
}


/*
if / if - else / if - else if - else 모두 java 와 문법은 동일
단 kotlin 에서는 Expression 으로 취급
때문에 kotlin 에서는 삼항 연산자가 없다.
kotlin 에서는 switch문 대신 when 으로 대체되었음.

*/