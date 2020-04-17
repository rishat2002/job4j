package ru.job4j.find;

public class FullCompare implements MetodSearch{
    @Override
    public boolean compareString(String filenameInDirectory, String filename) {
        if (filenameInDirectory.equals(filename)) {
            return true;
        }
        else {
            return false;
        }
    }
}
