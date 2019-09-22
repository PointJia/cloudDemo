package com.dian.demo.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileUtil {

    public static boolean writeFile(String filePath,byte[] bytes) throws IOException {
        File file = new File(filePath);
        try (FileOutputStream fos = new FileOutputStream(file)){
            fos.write(bytes);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }

}
