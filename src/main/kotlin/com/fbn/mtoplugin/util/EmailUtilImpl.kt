package com.fbn.mtoplugin.util

import org.springframework.mail.javamail.JavaMailSender
import org.springframework.mail.javamail.MimeMessageHelper
import org.springframework.stereotype.Component
import java.io.File
import java.nio.charset.StandardCharsets
import javax.mail.Message
import javax.mail.internet.InternetAddress
import javax.mail.internet.MimeBodyPart
import javax.mail.internet.MimeMessage
import javax.mail.internet.MimeMultipart


@Component
class EmailUtilImpl(private val javaMailSender: JavaMailSender) : EmailUtil {


    override fun sendEmail(toAddress: String?, subject: String, body: String)
    {
        val message: MimeMessage = javaMailSender.createMimeMessage()
        val helper = MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                StandardCharsets.UTF_8.name())
        helper.setFrom("noreply@firstbanknigeria.com");
        helper.setTo(toAddress!!)
        helper.setSubject(subject)
        helper.setText(body, true)
        javaMailSender.send(message)
    }

    override fun sendEmail(toAddress: String, subject: String, body: String, files : List<File>){
        val message = javaMailSender.createMimeMessage()
        message.setFrom(InternetAddress("noreply@firstbanknigeria.com"))
        val toAddresses = InternetAddress.parse(toAddress)
        message.setRecipients(Message.RecipientType.TO, toAddresses)
        val messageBodyPart = MimeBodyPart()
        messageBodyPart.setContent(body, "text/html")
        val multipart = MimeMultipart()
        multipart.addBodyPart(messageBodyPart)
        message.subject = subject
        try{
            for (file in files) {
                val attachPart = MimeBodyPart()
                attachPart.attachFile(file)
                multipart.addBodyPart(attachPart)
            }
            message.setContent(multipart)
            javaMailSender.send(message)
            println("Sent message successfully....")
        }catch (e : Exception){
            e.printStackTrace()
        }

    }


    override fun twilloSendEmail(toAddress: String?, subject: String?, body: String?) {
//        val from = Email("info@rubies.ng", "Corporate Internet Banking")
//        val to = Email(toAddress)
//        val content = Content("text/html", body)
//        val mail = Mail(from, subject, to, content)
//        val sg = SendGrid("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")
//        val firstapple = Request()
//        try {
//            firstapple.setMethod(Method.POST)
//            firstapple.setEndpoint("mail/send")
//            firstapple.setBody(mail.build())
//            val response: Response = sg.api(firstapple)
//        } catch (ex: IOException) {
//            println(ex.message)
//        }
    }
}
