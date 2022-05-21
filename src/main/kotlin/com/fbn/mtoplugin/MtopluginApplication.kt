package com.fbn.mtoplugin

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.core.env.Environment
import org.springframework.jndi.JndiTemplate
import javax.naming.NamingException
import javax.sql.DataSource

@SpringBootApplication
class MtopluginApplication


fun main(args: Array<String>) {
    runApplication<MtopluginApplication>(*args)
}


