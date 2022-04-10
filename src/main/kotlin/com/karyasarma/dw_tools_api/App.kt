package com.karyasarma.dw_tools_api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.util.*

/**
 * @author Daniel Joi Partogi Hutapea
 */
@SpringBootApplication
class App

fun main(args: Array<String>) {
    TimeZone.setDefault(TimeZone.getTimeZone("Asia/Jakarta"));
    runApplication<App>(*args)
}
