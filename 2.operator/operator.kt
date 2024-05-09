package main.kotlin.operator

import main.java.reference.lec04.JavaMoney

fun operator() {
    // 1. 산술 연산자
    // +(더하기), -(빼기), *(곱하기), /(나누기), %(나머지)
    // 여기서 특이한 점
    // 코틀린에서는 정수 / 정수 (나누기)하면 무조건 정수로 나옴
    // ex) 5(정수) / 2(정수) 하면 2.5(실수)를 예상했지만 그게 아닌 2(정수)로 반환됨
    // 그래서 2.5인 실수값을 기대한다면 값 중에 하나 이상을 .toDouble() 해주던가 실수로 변환시켜야 함. 이건 좀 불편~

    // 2. 복합 대입 연산자, 산술 대입 연산자
    // +=, -=, *=, /=, %=

    // 3. 증감 연산자, 단항 연산자
    // ++(1씩 증가), --(1씩 감소)

    // 4. 비교 연산자
    // <, <=, >, >=, ==, !=

    val money1 = JavaMoney(5_000L)
    val money2 = JavaMoney(2_000L)
    if (money1 > money2) {
        println("Money1이 Money2보다 금액이 큽니다.")
    }

    // java 에서는 동일성에 == 를 사용, 동등성에 equals 를 직접 호출
    // kotlin 에서는 동일성에 === 를 사용, 동등성에 == 를 호출 == 를 사용하면 간접적으로 equals 를 호출해준다. (물론 equals 를 오버라이딩에서 만들어줬을때)
    val money3 = JavaMoney(1_000L)
    val money4 = money3
    val money5 = JavaMoney(1_000L)

    println(money3 == money4)   // 항상 true
    println(money4 == money5)   // true  -> 서로 값은 동등하기 때문에 true
    println(money4 === money5)  // false -> 서로 값은 같아도 객체의 주소값은 다르기 때문에 동일성에 false

    // 5. 논리 연산자
    // ||(OR), &&(AND), !(NOT)

    // Lazy 연산
    if (fun1() || fun2()) {     // fun1 or fun2 둘 중 하나만 true 면 실행
        println("실행1")         // fun1 이 이미 true 이니깐 fun2 는 볼 필요도 없이 실행
    }

    if (fun1() && fun2()) {     // fun1 and fun2 둘 다 true 이여야 실행
        println("실행2")         // fun1 실행하고 fun2 실행했는데 false 여서 실행2 까지는 호출 못 함
    }

    if (fun2() && fun1()) {
        println("실행3")         // fun2 실행했는데 false 여서 fun1 실행 할 필요도 없음
    }


    // 6. 연산자 오버로딩
    // kotlin 에서는 객체마다 연산자를 직접 정의할 수 있다.

    val money6 = JavaMoney(1_000L)
    val money7 = JavaMoney(2_000L)
    println(money6 + money7)

}

fun fun1(): Boolean {
    println("fun 1")
    return true
}

fun fun2(): Boolean {
    println("fun 2")
    return false
}


fun kotlinMoney(value:Long): Long {
    return value
}

fun compare() {
    if (kotlinMoney(30L) > kotlinMoney(20L)) {
        println("hihi")
        println(kotlinMoney(50L) + kotlinMoney(40L))
    }

    val money9 = kotlinMoney(30L)
    val money0 = kotlinMoney(50L)
    println(money9 + money0)
}