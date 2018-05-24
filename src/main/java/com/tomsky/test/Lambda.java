package com.tomsky.test;

import junit.framework.TestCase;

import java.io.FileFilter;
import java.util.concurrent.Callable;

/**
 * Created by j-wangzhitao on 17-11-23.
 */
public class Lambda extends TestCase {
    public void testLambda() {
        System.out.println("test lambda");
        Callable<String> c = () -> "";

        filterFiles(new FileFilter[] {
                f -> f.exists(), f -> f.canRead(), f -> f.getName().startsWith("q")
        });
    }

    private String doWork(String work) {
        return "my work:"+work;
    }

    private void filterFiles(FileFilter[] fileFilter) {

    }
}
