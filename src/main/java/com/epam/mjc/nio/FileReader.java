package com.epam.mjc.nio;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.stream.Stream;


public class FileReader {

    private static final String WORDS_SEPARATOR = " ";

    public Profile getDataFromFile(File file) {
        String path = file.getAbsolutePath();
        Profile profile = new Profile();
        try (Stream<String> stream = Files.lines(Paths.get(path))) {
            stream.forEach(line -> {
                String[] arr = line.split(WORDS_SEPARATOR);
                switch (arr[0]) {
                    case "Name:":
                        profile.setName(arr[1]);
                        break;
                    case "Age:":
                        profile.setAge(Integer.parseInt(arr[1]));
                        break;
                    case "Email:":
                        profile.setEmail(arr[1]);
                        break;
                    case "Phone:":
                        profile.setPhone(Long.parseLong(arr[1]));
                        break;
                    default:
                        throw new NoSuchElementException();
                }
            });
        } catch (IOException e) {
            throw new CustomReadException(e.getMessage());
        }
        return profile;
    }
}