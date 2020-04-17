package ru.job4j.find;

public class RegexCompare implements MetodSearch {
    @Override
    public boolean compareString(String filenameInDirectory, String filename) {
        if (filenameInDirectory.matches(filename)) {
            return true;
        }
        else {
            return false;
        }
    }
}
