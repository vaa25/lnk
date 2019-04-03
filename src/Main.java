import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Properties;

public class Main {

    public static void main(final String...args) throws IOException {
        final String home = System.getProperty("user.home");
        final Properties properties = webstorm2018_3();
        final String folder =home + properties.getProperty("path");
        final String builder = new LinkBuilder()
            .exec(folder + properties.getProperty("exec"))
            .icon(folder + properties.getProperty("icon"))
            .path(folder)
            .name(properties.getProperty("name"))
            .terminal(false)
            .keyword(properties.getProperty("keyword"))
            .build();
        final String desktop = properties.getProperty("desktop");
        final Path path = Paths.get(home, "Desktop", desktop);
        Files.deleteIfExists(path);
        Files.createFile(path);
        Files.write(path, builder.getBytes(Charset.forName("utf-8")));
        Files.setPosixFilePermissions(path, PosixFilePermissions.fromString("rwxr-x---"));
        Files.copy(path, Paths.get(home, ".local", "share", "applications", desktop));

    }

    private static Properties jmeter5_0(){
        final Properties properties = new Properties();
        properties.put("path", "/environment/apache-jmeter-5.0");
        properties.put("exec", "/bin/jmeter.sh");
        properties.put("icon", "/docs/images/mstile-144x144.png");
        properties.put("name", "Jmeter 5.0");
        properties.put("keyword", "jmeter");
        properties.put("desktop", "jmeter.5.0.desktop");
        return properties;
    }

    private static Properties idea2018_3(){
        final Properties properties = new Properties();
        properties.put("path", "/environment/ideaIU-2018.3");
        properties.put("exec", "/bin/idea.sh");
        properties.put("icon", "/bin/idea.png");
        properties.put("name", "Idea 2018.3");
        properties.put("keyword", "idea");
        properties.put("desktop", "idea.2018.3.desktop");
        return properties;
    }

    private static Properties webstorm2018_3(){
        final Properties properties = new Properties();
        properties.put("path", "/environment/WebStorm-2018.3.2/WebStorm-183.4886.41");
        properties.put("exec", "/bin/webstorm.sh");
        properties.put("icon", "/bin/webstorm.png");
        properties.put("name", "Webstorm 2018.3.2");
        properties.put("keyword", "webstorm");
        properties.put("desktop", "webstorm.2018.3.2.desktop");
        return properties;
    }
}
