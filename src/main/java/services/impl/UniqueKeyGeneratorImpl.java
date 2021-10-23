package services.impl;

import helper.Base62;
import services.UniqueKeyGenerator;

import java.math.BigInteger;

public class UniqueKeyGeneratorImpl implements UniqueKeyGenerator {

    private BigInteger counter = BigInteger.ZERO;

    /**
     *
     * @return unique Base62 String
     */
    @Override
    public String getNewKey() {
        BigInteger value = getBigInteger();
        return Base62.encode(value);
    }

    /**
     * synchronized method to handle concurrent calls.
     * @return unique BigInteger
     */
    private synchronized BigInteger getBigInteger() {
        counter = counter.add(BigInteger.ONE);
        return counter;
    }
}
