package com.vladavekin.logic.controller.file;

public class WriteFile {
//
//    Read read = new Read();
//
//    public void write(Fille fille, StringBuilder text) {
//        //Определяем файл
//
//        File file = new File(fille.getFilleName());
//
//        try {
//            //проверяем, что если файл не существует то создаем его
//            if(!file.exists()){
//                file.createNewFile();
//            }
//
//            //PrintWriter обеспечит возможности записи в файл
//            PrintWriter out = new PrintWriter(file.getAbsoluteFile());
//
//            try {
//                //Записываем текст у файл
//                out.print(text);
//            } finally {
//                //После чего мы должны закрыть файл
//                //Иначе файл не запишется
//                out.close();
//            }
//        } catch(IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    public void update(Fille fille, StringBuilder newText) throws FileNotFoundException {
//        exists(fille.getFilleName());
//        StringBuilder sb = new StringBuilder();
//        StringBuilder oldFile = read.read(fille);
//        sb.append(oldFile);
//        sb.append(newText);
//
//        write(fille, sb);
//    }
//
//    private void exists(String fileName) throws FileNotFoundException {
//        File file = new File(fileName);
//        if (!file.exists()){
//            throw new FileNotFoundException(file.getName());
//        }
//    }

}
