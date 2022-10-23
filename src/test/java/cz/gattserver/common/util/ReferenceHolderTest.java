package cz.gattserver.common.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class ReferenceHolderTest {

    @Test
    public void test() {
        BigDecimal bd = new BigDecimal(4.255);
        ReferenceHolder<BigDecimal> holder = new ReferenceHolder<>();
        holder.setValue(bd);
        assertEquals(bd, holder.getValue());
    }

    @Test
    public void test_staticInteger() {
        Integer i = Integer.valueOf(15);
        ReferenceHolder<Integer> holder = ReferenceHolder.newIntegerHolder();
        holder.setValue(i);
        assertEquals(i, holder.getValue());
    }

    @Test
    public void test_staticInteger2() {
        Integer i = Integer.valueOf(15);
        ReferenceHolder<Integer> holder = ReferenceHolder.newIntegerHolder(i);
        assertEquals(i, holder.getValue());
    }

    @Test
    public void test_staticBoolean() {
        Boolean b = Boolean.TRUE;
        ReferenceHolder<Boolean> holder = ReferenceHolder.newBooleanHolder();
        holder.setValue(b);
        assertEquals(b, holder.getValue());
    }

    @Test
    public void test_staticBoolean2() {
        Boolean b = Boolean.TRUE;
        ReferenceHolder<Boolean> holder = ReferenceHolder.newBooleanHolder(b);
        assertEquals(b, holder.getValue());
    }

}
