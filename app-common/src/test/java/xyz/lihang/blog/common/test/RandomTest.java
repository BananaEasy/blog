package xyz.lihang.blog.common.test;

import org.junit.Test;
import xyz.lihang.blog.common.tool.utils.RandomUtils;

import java.util.Arrays;
import java.util.Date;
import java.util.Random;

public class RandomTest {
    @Test
    public void test(){
        long s = new Date().getTime();
        int[] ints = RandomUtils.randomCommon(0, 5, 6);
        System.out.println(Arrays.toString(ints));
        System.out.println("时间：" + (new Date().getTime() - s) + "ms");
    }

}
