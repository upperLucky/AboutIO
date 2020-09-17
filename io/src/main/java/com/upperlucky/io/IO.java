package com.upperlucky.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import okio.Buffer;
import okio.BufferedSource;
import okio.Okio;
import okio.Sink;
import okio.Source;

/**
 * created by yunKun.wen on 2020/9/16
 * desc:
 */
class IO {
    public static void main(String[] args) {
//        ioReader();
//        ioCopy();
//        okIoReader();
        okIoCopy();
    }

    private static void okIoCopy() {
        try (Source source = Okio.source(new File("./io/test.txt"));
             Sink sink = Okio.sink(new File("./io/copy_test.txt"));
             Buffer buffer = new Buffer()) {
            sink.write(buffer,source.read(buffer, 1024));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void okIoReader() {
        try (Source source = Okio.source(new File("./io/copy.txt"));
             BufferedSource bufferedSource = Okio.buffer(source)) {
            System.out.println(bufferedSource.readUtf8Line());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void ioCopy() {
        try (FileInputStream inputStream = new FileInputStream("./io/test.txt");
             FileOutputStream outputStream = new FileOutputStream("./io/copy.txt")) {
            byte[] data = new byte[1024];
            int read;
            while ((read = inputStream.read(data)) != -1) {
                outputStream.write(data, 0, read);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void ioReader() {
        try (FileInputStream inputStream = new FileInputStream("./io/test.txt");
             InputStreamReader reader = new InputStreamReader(inputStream);
             BufferedReader bufferedReader = new BufferedReader(reader)) {
            System.out.println(bufferedReader.readLine());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
