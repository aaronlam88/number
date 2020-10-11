package number.utils.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.zip.GZIPOutputStream;

import org.apache.commons.lang3.SerializationUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FileIO {
    private FileIO() {
        throw new IllegalStateException("Utility class");
    }

    public static <T extends Serializable> boolean saveAsGzip(URI filePath, T object) {
        return saveAsGzip(filePath.getPath(), object);
    }

    public static <T extends Serializable> boolean saveAsGzip(String filePath, T object) {
        File file = Paths.get(filePath).toFile();
        try (FileOutputStream fileOutputStream = new FileOutputStream(file)) {
            GZIPOutputStream gzip = new GZIPOutputStream(fileOutputStream);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(gzip);
            objectOutputStream.writeObject(object);
            return true;
        } catch (Exception e) {
            log.error(e.getLocalizedMessage(), e);
        }
        return false;
    }

    public static <T extends Serializable> boolean saveAsJson(URI filePath, T object) {
        return saveAsJson(filePath.getPath(), object);
    }

    public static <T extends Serializable> boolean saveAsJson(String filePath, T object) {
        try {
            Path path = Paths.get(filePath);
            byte[] bytes = SerializationUtils.serialize(object);
            Files.write(path, bytes, StandardOpenOption.CREATE);
            return true;
        } catch (Exception e) {
            log.error(e.getLocalizedMessage(), e);
        }
        return false;
    }
}