package net.glomc.apis.loadbalancer.common.utils.ip;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class IpChecker {

    private static final URL ipCheckingUrl;

    static {
        try {
            ipCheckingUrl = new URL("http://checkip.amazonaws.com");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getAddress() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(ipCheckingUrl.openStream()));
        String ip = in.readLine();
        in.close();
        return ip;
    }


}
