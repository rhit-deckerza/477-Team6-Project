package net.sf.jftp.tools;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.StringTokenizer;

public class ConfigLoader {

    private static Properties properties = new Properties();

    static {
        try {
            properties.load(new FileInputStream("config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String[] loadTypeArray() {
        return tokenize(properties.getProperty("typeArray"));
    }

    public static String[] loadTermArray() {
        return tokenize(properties.getProperty("termArray"));
    }

    public static String[] loadOptArray() {
        return tokenize(properties.getProperty("optArray"));
    }

    public static String[] loadIgnoreArray() {
        return tokenize(properties.getProperty("ignoreArray"));
    }

    public static String[] loadScanArray() {
        return tokenize(properties.getProperty("scanArray"));
    }
    public static String getHostname() {
        return properties.getProperty("hostname", "localhost");
    }

    public static String getUsername() {
        return properties.getProperty("username", "anonymous");
    }

    public static String getPassword() {
        return properties.getProperty("password", "none@nowhere.no");
    }

    public static String getPort() {
        return properties.getProperty("port", "21");
    }

    public static String getMaxConnections() {
        return properties.getProperty("maxConnections", "3");
    }

    public static String getOverrideServerNewline() {
        return properties.getProperty("overrideServerNewline", "<default>");
    }

    private static String[] tokenize(String property) {
        StringTokenizer tokenizer = new StringTokenizer(property, ",");
        String[] tokens = new String[tokenizer.countTokens()];
        int index = 0;
        while (tokenizer.hasMoreTokens()) {
            tokens[index++] = tokenizer.nextToken();
        }
        return tokens;
    }
}
