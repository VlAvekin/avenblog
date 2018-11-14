package com.vladavekin.logic.controller.file;


import com.vladavekin.logic.model.FileMy;
import com.vladavekin.logic.model.file.IReader;

import java.io.*;


public class ReaderFile implements IReader {

    private FileMy fileMy;

    public ReaderFile(final FileMy fileMy) {

        this.fileMy = fileMy;
    }

    @Override
    public void read() {

        try {
            //Объект для чтения файла в буфер
            BufferedReader in = new BufferedReader(new FileReader(fileMy.getFileName()));
            try {
                //В цикле построчно считываем файл
                String s;
                while ((s = in.readLine()) != null) {
                    fileMy.add(s);
                }
            } finally {
                //Также не забываем закрыть файл
                in.close();
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void exists(FileMy fileMy) throws FileNotFoundException {
        File file = new File(fileMy.getFileName());
        if (!file.exists()){
            throw new FileNotFoundException(file.getName());
        }
    }
}
