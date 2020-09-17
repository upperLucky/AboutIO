package com.upperlucky.io

import java.io.*

/**
 * created by yunKun.wen on 2020/9/16
 * desc:
 */
fun main() {
//    ioReader()
    ioCopy()
}

fun ioCopy() {
    val fileInputStream = FileInputStream("./io/test.txt")
    val fileOutputStream = FileOutputStream("./io/copy.txt")
   val data = byteArrayOf()
//    while (read != -1) {
//fileOutputStream.write()
//    }
}

fun ioReader() {
    val fileInputStream = FileInputStream("./io/test.txt")
    val reader = InputStreamReader(fileInputStream)
    val bufferedReader = BufferedReader(reader)
    println(bufferedReader.readLine())
    bufferedReader.close()
}