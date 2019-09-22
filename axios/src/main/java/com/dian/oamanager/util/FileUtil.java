package com.dian.oamanager.util;

import java.io.*;

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

    public static boolean writeFile(InputStream inputStream,String file) throws IOException {
        File f = new File(file);

        try (FileOutputStream outputStream = new FileOutputStream(f)){
            ;
            byte[] bytes = new byte[1024];

            while ((inputStream.read(bytes)) > 0){
                outputStream.write(bytes);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            inputStream.close();
        }

        return false;

    }


}
