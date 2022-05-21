package com.fbn.mtoplugin.config

import org.apache.http.conn.ssl.NoopHostnameVerifier
import org.apache.http.conn.ssl.SSLConnectionSocketFactory
import org.apache.http.conn.ssl.TrustStrategy
import org.apache.http.impl.client.HttpClients
import org.apache.http.ssl.SSLContexts
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.Resource
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory
import org.springframework.web.client.RestTemplate
import java.io.File
import java.io.FileInputStream
import java.security.KeyManagementException
import java.security.KeyStore
import java.security.KeyStoreException
import java.security.NoSuchAlgorithmException
import java.security.cert.X509Certificate
import javax.net.ssl.HostnameVerifier
import javax.net.ssl.SSLSession


@Configuration
class RestClientConfig {
    @Value("classpath:101575.pfx")
    lateinit var resource : Resource

    @Bean
    @Throws(KeyStoreException::class, NoSuchAlgorithmException::class, KeyManagementException::class)
    fun restTemplate(): RestTemplate {
        val acceptingTrustStrategy = TrustStrategy { _: Array<X509Certificate?>?, _: String? -> true }
        val allPassVerifier = HostnameVerifier { _: String?, _: SSLSession? -> true }
        val input = FileInputStream(resource.file)
        val keyStore = KeyStore.getInstance("PKCS12")
        keyStore.load(input, "NU}xfc={DvYH".toCharArray())
        val sslContext = SSLContexts.custom().loadTrustMaterial(null, acceptingTrustStrategy)
            .loadKeyMaterial(keyStore, "NU}xfc={DvYH".toCharArray()).build();
        val csf = SSLConnectionSocketFactory(sslContext, arrayOf("TLSv1", "TLSv1.1", "TLSv1.2"), null, allPassVerifier)
        val httpClient = HttpClients.custom().setSSLSocketFactory(csf).setSSLHostnameVerifier(NoopHostnameVerifier.INSTANCE).build()
        val factory = HttpComponentsClientHttpRequestFactory(httpClient)
        return RestTemplate(factory)
    }



}