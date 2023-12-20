package com.fly.test.deep_think_jvm_2.chapter2;

/**
 * VM Args： -Xss2M （这时候不妨设大些， 请在32位系统下运行）
 * @author zzm
 */
public class _2_6_JavaVMStackOOM {
    private void dontStop() {
        while (true) {
        }
    }

    public void stackLeakByThread() {
        while (true) {
            Thread thread = new Thread(() -> dontStop());
            thread.start();
        }
    }

    public static void main(String[] args) throws Throwable {
        _2_6_JavaVMStackOOM oom = new _2_6_JavaVMStackOOM();
        oom.stackLeakByThread();
    }

}
