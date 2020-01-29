/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.camel.converter.crypto.springboot;

import javax.annotation.Generated;
import org.apache.camel.spring.boot.DataFormatConfigurationPropertiesCommon;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Crypto data format is used for encrypting and decrypting of messages using
 * Java Cryptographic Extension.
 * 
 * Generated by camel-package-maven-plugin - do not edit this file!
 */
@Generated("org.apache.camel.springboot.maven.SpringBootAutoConfigurationMojo")
@ConfigurationProperties(prefix = "camel.dataformat.crypto")
public class CryptoDataFormatConfiguration
        extends
            DataFormatConfigurationPropertiesCommon {

    /**
     * Whether to enable auto configuration of the crypto data format. This is
     * enabled by default.
     */
    private Boolean enabled;
    /**
     * The JCE algorithm name indicating the cryptographic algorithm that will
     * be used.
     */
    private String algorithm;
    /**
     * The name of the JCE Security Provider that should be used.
     */
    private String cryptoProvider;
    /**
     * Refers to the secret key to lookup from the register to use.
     */
    private String keyRef;
    /**
     * Refers to a byte array containing the Initialization Vector that will be
     * used to initialize the Cipher.
     */
    private String initVectorRef;
    /**
     * A JCE AlgorithmParameterSpec used to initialize the Cipher. Will lookup
     * the type using the given name as a
     * java.security.spec.AlgorithmParameterSpec type.
     */
    private String algorithmParameterRef;
    /**
     * The size of the buffer used in the signature process.
     */
    private Integer buffersize;
    /**
     * The JCE algorithm name indicating the Message Authentication algorithm.
     */
    private String macAlgorithm = "HmacSHA1";
    /**
     * Flag indicating that a Message Authentication Code should be calculated
     * and appended to the encrypted data.
     */
    private Boolean shouldAppendHMAC = true;
    /**
     * Flag indicating that the configured IV should be inlined into the
     * encrypted data stream. Is by default false.
     */
    private Boolean inline = false;
    /**
     * Whether the data format should set the Content-Type header with the type
     * from the data format if the data format is capable of doing so. For
     * example application/xml for data formats marshalling to XML, or
     * application/json for data formats marshalling to JSon etc.
     */
    private Boolean contentTypeHeader = false;

    public String getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }

    public String getCryptoProvider() {
        return cryptoProvider;
    }

    public void setCryptoProvider(String cryptoProvider) {
        this.cryptoProvider = cryptoProvider;
    }

    public String getKeyRef() {
        return keyRef;
    }

    public void setKeyRef(String keyRef) {
        this.keyRef = keyRef;
    }

    public String getInitVectorRef() {
        return initVectorRef;
    }

    public void setInitVectorRef(String initVectorRef) {
        this.initVectorRef = initVectorRef;
    }

    public String getAlgorithmParameterRef() {
        return algorithmParameterRef;
    }

    public void setAlgorithmParameterRef(String algorithmParameterRef) {
        this.algorithmParameterRef = algorithmParameterRef;
    }

    public Integer getBuffersize() {
        return buffersize;
    }

    public void setBuffersize(Integer buffersize) {
        this.buffersize = buffersize;
    }

    public String getMacAlgorithm() {
        return macAlgorithm;
    }

    public void setMacAlgorithm(String macAlgorithm) {
        this.macAlgorithm = macAlgorithm;
    }

    public Boolean getShouldAppendHMAC() {
        return shouldAppendHMAC;
    }

    public void setShouldAppendHMAC(Boolean shouldAppendHMAC) {
        this.shouldAppendHMAC = shouldAppendHMAC;
    }

    public Boolean getInline() {
        return inline;
    }

    public void setInline(Boolean inline) {
        this.inline = inline;
    }

    public Boolean getContentTypeHeader() {
        return contentTypeHeader;
    }

    public void setContentTypeHeader(Boolean contentTypeHeader) {
        this.contentTypeHeader = contentTypeHeader;
    }
}