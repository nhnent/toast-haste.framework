/*
* Copyright 2016 NHN Entertainment Corp.
*
* NHN Entertainment Corp. licenses this file to you under the Apache License,
* version 2.0 (the "License"); you may not use this file except in compliance
* with the License. You may obtain a copy of the License at:
*
*   http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package com.nhnent.haste.security;

import java.util.Random;

public class DiffieHellman {
    private static final BigInteger baseNumber = OakleyGroup1.generator;
    private static final BigInteger primeNumber = OakleyGroup1.primeNumber;
    private static final Random random = new Random();

    public static BigInteger generateSecretKey(BigInteger remotePublicKey, BigInteger privateKey) {
        return remotePublicKey.modPow(privateKey, primeNumber);
    }

    public static BigInteger generatePublicKey(BigInteger privateKey) {
        return baseNumber.modPow(privateKey, primeNumber);
    }

    public static BigInteger generatePrivateKey(int bitLength) {
        return BigInteger.probablePrime(bitLength, random);
    }
}