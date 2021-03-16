String directory = System.getProperty("user.home");
String fileName = "sample.txt";
String absolutePath = directory + File.separator + fileName;

// write the content in file 
try(BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(absolutePath))) {
    String fileContent = "This is a sample text.";
    bufferedOutputStream.write(fileContent.getBytes());
} catch (IOException e) {
    // exception handling
}

// read the content from file
try(BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(absolutePath))) {
    int ch = bufferedInputStream.read();
    while(ch != -1) {
        System.out.print((char)ch);
        ch = bufferedInputStream.read();
    }
} catch (FileNotFoundException e) {
    // exception handling
} catch (IOException e) {
    // exception handling
}
