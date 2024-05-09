package main.kotlin.array

import java.util.Scanner
import kotlin.random.Random

fun array() {
    // 배열
    // Array<변수타입>(배열사이즈) { 초기값 }
    // arrayOf<변수타입>(특정값1, 특정값2, 특정값3)

    val records1 = Array<Int>(5){0}
    val records2 = arrayOf(100, 200, 300, 400, 500, 600, 700, 800, 900)

    records1[0] = 100
    records1[1] = 200
    records1[2] = 300
    records1[3] = 400
    records1[4] = 500

    // 1
    for (index: Int in 1..records1.size) {
        println("${index}번 회원님의 3대 운동 기록은 ${records1[index-1]} 입니다.")
    }

    //2
    for (index in records2.indices) {
        println("${index +1}번 회원님의 3대 운동 기록은 ${records2[index]} 입니다.")
    }

    ///////////////////////////////////////

    // 2차원 배열
    val records3 = arrayOf(
        arrayOf(1,2,3,4,5),
        arrayOf(6,7,8,9,0),
        arrayOf(11,22,33,44,55),
    )

    records3[0][2] = 33

    // 2차원 배열 값 읽기
    for (row in records3) {
        for (colum in row) {
            println("value = $colum")
        }
    }

    ///////////////////////////////////////

    // 1 ~ 100 까지 랜덤한 수를 배열에 저장, 가장 작은 수와 가장 큰 수 찾기
    val randomNumbers = Array(10) { Random.nextInt(100) + 1}
    var min1: Int = randomNumbers[0]
    var max1: Int = randomNumbers[0]
    println("array : ${randomNumbers.toList()}")

    for (number in randomNumbers) {
        if (number < min1) {
            min1 = number
        }
        if (number > max1) {
            max1 = number
        }
    }
    println("min1 = $min1")
    println("max1 = $max1")

    // 치트키
    var min2: Int = randomNumbers.min()
    var max2: Int = randomNumbers.max()
    println("min2 = $min2")
    println("max2 = $max2")

    ///////////////////////////////////////

    // 평균 값 구하기
    val sc = Scanner(System.`in`)
    val array2 = Array<Int>(5) {0}

    for (index in array2.indices) {
        println("숫자를 입력해주세요 : ")
        array2[index] = sc.nextInt()
    }

    var total = 0

    for (value in array2) {
        total += value
    }

    val average = total / array2.size.toDouble()
    println("평균값은 : ${average}")

    // 치트키
    println("평균값은 : ${array2.average()}")
}