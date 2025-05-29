package com.example;

import static java.util.concurrent.Executors.newFixedThreadPool;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Random;

public class Exercise05 {
    private static final int BUFFER_SIZE = 1024 * 1024; // 1 MB buffer
    private static final String FILE_NAME = "io_wait_test_file_";
    private static final long FILE_SIZE = 1024 * 1024 * 1024; // 1 GB file size
    private static final int THREAD_COUNT = 4; // Number of concurrent threads

    public static void main(String[] args) {
        var executorService = newFixedThreadPool(THREAD_COUNT);

        for (var i = 0; i < THREAD_COUNT; i++) {
            final var fileIndex = i;
            executorService.submit(() -> {
                try {
                    performIO(fileIndex);
                } catch (IOException e) {
                    System.err.println("Error during I/O: " + e.getMessage());
                }
            });
        }

        executorService.shutdown();
    }

    private static void performIO(int fileIndex) throws IOException {
        var file = new File(FILE_NAME + fileIndex + ".dat");
        var buffer = new byte[BUFFER_SIZE];
        new Random().nextBytes(buffer);

        while (true) {
            try (var raf = new RandomAccessFile(file, "rw")) {
                var bytesWritten = 0;
                while (bytesWritten < FILE_SIZE) {
                    raf.write(buffer);
                    bytesWritten += buffer.length;
                }
                raf.getFD().sync(); // Force write to disk without caching
            }
            // Delete and recreate the file to increase I/O pressure
            file.delete();
        }
    }
}
