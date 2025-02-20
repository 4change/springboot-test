package com.fly.test.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CpeUtils {

    public static void main(String[] args) {
        purlToCpe23();
    }

    public static void purlToCpe23() {
        String namespace = "sun";
        String name = "nfs";
        String version = null;
        String cpeStr = "^cpe:2\\.3:[aho]"
                + (StringUtils.isBlank(namespace) ? "(:([\\w\\-\\.]+|\\*))" : "(:(" + namespace + "))")
                + (StringUtils.isBlank(name) ? "(:([\\w\\-\\.]+|\\*))" : "(:(" + name + "))")
                + (StringUtils.isBlank(version) ? "(:([\\w\\-\\.]+|\\*))" : "(:(" + version + "))")
                + "(:([\\w\\-\\.]+|\\*)){7}$";

        Pattern pattern = Pattern.compile(cpeStr);
        Matcher matcher = pattern.matcher("cpe:2.3:a:sun:nfs:*:*:*:*:*:*:*:*");
        System.out.println(matcher.matches());
    }

}
