package com.fbn.mtoplugin.config

import org.apache.http.conn.ssl.NoopHostnameVerifier
import org.apache.http.conn.ssl.SSLConnectionSocketFactory
import org.apache.http.conn.ssl.TrustStrategy
import org.apache.http.impl.NoConnectionReuseStrategy
import org.apache.http.impl.client.HttpClients
import org.apache.http.ssl.SSLContexts
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory
import org.springframework.web.client.RestTemplate
import java.security.KeyManagementException
import java.security.KeyStoreException
import java.security.NoSuchAlgorithmException
import java.security.cert.X509Certificate
import javax.net.ssl.HostnameVerifier
import javax.net.ssl.SSLSession


class RestTemplateConfig{

    @Throws(KeyStoreException::class, NoSuchAlgorithmException::class, KeyManagementException::class)
    fun restTemplate(): RestTemplate {
        val acceptingTrustStrategy = TrustStrategy { _: Array<X509Certificate?>?, _: String? -> true }
        val allPassVerifier = HostnameVerifier { _: String?, _: SSLSession? -> true }
        val sslContext = SSLContexts.custom().loadTrustMaterial(null, acceptingTrustStrategy).build();
        val csf = SSLConnectionSocketFactory(sslContext, arrayOf("TLSv1", "TLSv1.1", "TLSv1.2"),
                null, allPassVerifier)

        val httpClient = HttpClients.custom().setSSLSocketFactory(csf)
                .setConnectionReuseStrategy(NoConnectionReuseStrategy())
                .setSSLHostnameVerifier(NoopHostnameVerifier.INSTANCE).build()
        val factory = HttpComponentsClientHttpRequestFactory(httpClient)
        return RestTemplate(factory)
    }
}