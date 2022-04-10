package com.karyasarma.dw_tools_api.controller

import com.karyasarma.dw_tools_api.aop.Person
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * @author Daniel Joi Partogi Hutapea
 */
@RestController
@RequestMapping("/person")
@Validated
class PersonController
{
    @PostMapping("/")
    fun parse(@Validated @RequestBody request: Person): ResponseEntity<Person>
    {
        return ResponseEntity.ok(request)
    }
}
